package org.example.chatbot.domain.zsxq.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.chatbot.domain.zsxq.IZsxqApi;
import org.example.chatbot.domain.zsxq.model.aggregate.UnAnsweredQuestionsAggregate;
import org.example.chatbot.domain.zsxq.model.req.AnswerReq;
import org.example.chatbot.domain.zsxq.model.req.ReqData;
import org.example.chatbot.domain.zsxq.model.res.AnswerResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wangcai
 * @description
 * @date 2025/12/21
 */
@Service
public class ZsxqApi implements IZsxqApi {

    private static final Logger log = LoggerFactory.getLogger(ZsxqApi.class);

    @Override
    public UnAnsweredQuestionsAggregate queryUnAnsweredQuestionsTopicId(
            String groupId, String cookie) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/" + groupId + "/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json;charset=utf-8");

        CloseableHttpResponse execute = httpClient.execute(get);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            log.info("拉取提问数据：groupId：{} jsonStr：{}", groupId, response);
            return JSON.parseObject(response, UnAnsweredQuestionsAggregate.class);
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
        return null;
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId,
                          String text, boolean silenced) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/" + topicId + "/answer");
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("Origin", "https://wx.zsxq.com/");
        post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36");

        AnswerReq answerReq = new AnswerReq(new ReqData(text, silenced));

        StringEntity stringEntity = new StringEntity(
                JSONObject.toJSONString(answerReq), ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            log.info("知识星球回答结果，groupId：{} topicId：{} jsonStr：{}", groupId, topicId, response);
            AnswerResp answerRes = JSON.parseObject(response, AnswerResp.class);
            return answerRes.isSucceeded();
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
        return silenced;
    }

}
