package org.example.chatbot.application.job;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.example.chatbot.domain.xiaomi.IXiaomiService;
import org.example.chatbot.domain.zsxq.IZsxqApi;
import org.example.chatbot.domain.zsxq.model.aggregate.UnAnsweredQuestionsAggregate;
import org.example.chatbot.domain.zsxq.model.vo.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @author wangcai
 * @description 机器人的定时任务
 * @date 2025/12/21
 */
@EnableScheduling
@Configuration
public class ChatbotSchedule {

    private static final Logger log = LoggerFactory.getLogger(ChatbotSchedule.class);

    @Value("${zsxq.cookie}")
    private String cookie;

    @Value("${zsxq.groupId}")
    private String groupId;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IXiaomiService xiaomiService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        // 随机休眠避免风控
        if (new Random().nextBoolean()) {
            log.info("随机休眠中...");
            return;
        }

        // 凌晨后不再回答
        GregorianCalendar calendar = new GregorianCalendar();
        if (calendar.get(GregorianCalendar.HOUR_OF_DAY) > 22 || calendar.get(GregorianCalendar.HOUR_OF_DAY) < 7) {
            log.info("当前时间：{} 点，打烊时间不再回答", calendar.get(GregorianCalendar.HOUR_OF_DAY));
            return;
        }

        try {
            UnAnsweredQuestionsAggregate unAnsweredQuestionsAggregate = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
            log.info("待回答结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregate));
            List<Topic> topics = unAnsweredQuestionsAggregate.getResp_data().getTopics();
            if(null == topics || topics.isEmpty()) {
                log.info("本次检索没有待回答的问题");
                return;
            }

            topics.forEach(topic -> {
                String topicId = topic.getTopic_id();
                String text = topic.getQuestion().getText();
                log.info("topicId：{}，text：{}", topicId, text);

                try {
                    String response = xiaomiService.doChat(text);
                    log.info("Xiaomi MIMO Response: {}", response);
                    boolean b = zsxqApi.answer(groupId, cookie, topicId, response, false);
                    log.info("答案提交成功结果：{}", b);
                    Thread.sleep(5000); // 5 seconds
                } catch (Exception e) {
                    log.error("Xiaomi MIMO error: {}", e.getMessage(), e);
                }
            });
        } catch (Exception e) {
            log.error("ChatbotSchedule error: {}", e.getMessage(), e);
        }
    }



}
