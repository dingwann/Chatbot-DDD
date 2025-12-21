package org.example.chatbot.api;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.example.chatbot.domain.xiaomi.IXiaomiService;
import org.example.chatbot.domain.zsxq.IZsxqApi;
import org.example.chatbot.domain.zsxq.model.aggregate.UnAnsweredQuestionsAggregate;
import org.example.chatbot.domain.zsxq.model.vo.Topic;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @author wangcai
 * @description 单元测试
 * @date 2025/12/21
 */
@SpringBootTest
@ActiveProfiles("dev")
public class SpringBootApiTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApiTest.class);

    @Value("${zsxq.cookie}")
    private String cookie;

    @Value("${zsxq.groupId}")
    private String groupId;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IXiaomiService xiaomiService;

    @Test
    public void test_apiTest() throws Exception {
        UnAnsweredQuestionsAggregate unAnsweredQuestionsAggregate =
                zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);

        log.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregate));

        List<Topic> topics = unAnsweredQuestionsAggregate.getResp_data().getTopics();
        for (Topic topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            log.info("topicId：{}，text：{}", topicId, text);
        }
    }

    @Test
    public void test_answer() throws Exception {
        String s = xiaomiService.doChat("你叫什么名字？");
        log.info("测试结果：{}", s);
    }
}
