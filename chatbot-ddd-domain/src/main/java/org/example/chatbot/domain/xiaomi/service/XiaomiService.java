package org.example.chatbot.domain.xiaomi.service;

import com.alibaba.fastjson2.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.chatbot.domain.xiaomi.IXiaomiService;
import org.example.chatbot.domain.xiaomi.model.req.MIMORequest;
import org.example.chatbot.domain.xiaomi.model.req.Messages;
import org.example.chatbot.domain.xiaomi.model.req.Thinking;
import org.example.chatbot.domain.xiaomi.model.res.MIMORespond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangcai
 * @description Xiaomi MIMO对话实现
 * @date 2025/12/21
 */
@Service
public class XiaomiService implements IXiaomiService {

    private static final Logger log = LoggerFactory.getLogger(XiaomiService.class);

    @Value("${xiaomi.api-key}")
    private String apiKey;

    @Override
    public String doChat(String message) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.xiaomimimo.com/v1/chat/completions");
        post.addHeader("api-key", apiKey);
        post.addHeader("Content-Type", "application/json");

        Messages system = Messages.builder().role("system")
                .content("You are MiMo, an AI assistant developed by Xiaomi. Today is date: Tuesday, December 16, 2025. Your knowledge cutoff date is December 2024. Answer in Chinese")
                .build();
        Messages user = Messages.builder().role("user").content(message).build();

        MIMORequest request = MIMORequest.builder()
                .model("mimo-v2-flash")
                .messages(List.of(system, user))
                .max_completion_tokens("1024")
                .temperature(0.85)
                .top_p(0.95)
                .stream(false)
                .stop(null)
                .frequency_penalty("0")
                .presence_penalty("0")
                .thinking(Thinking.builder().type("disabled").build())
                .build();

        StringEntity stringEntity = new StringEntity(
                JSON.toJSONString(request), ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            log.info("Xiaomi MIMO Response: {}", response);
            MIMORespond mimoRespond = JSON.parseObject(response, MIMORespond.class);
            return mimoRespond.getChoices().get(0).getMessage().getContent();
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
        return "null";
    }

}
