package org.example.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

/**
 * @author wangcai
 * @description 单元测试
 * @date 2025/12/20
 */
@SpringBootTest
@ActiveProfiles("dev") // 指定配置文件
public class ApiTest {

    @Value("${zsxq.cookie}")
    private String cookie;

    @Value("${xiaomi.api-key}")
    private String apiKey;

    @Test
    public void queryUnanswered() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88882218288412/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json;charset=utf-8");

        CloseableHttpResponse execute = httpClient.execute(get);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            System.out.println(response);
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 14588548525581222
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/14588548525421882/answer");
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("Origin", "https://wx.zsxq.com/");

        String parseJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"adada\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(
                parseJson, ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            System.out.println(response);
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
    }

    @Test
    public void xiaomiMIMOTest() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.xiaomimimo.com/v1/chat/completions");
        post.addHeader("api-key", apiKey);
        post.addHeader("Content-Type", "application/json");

        String reqJson = """
                {
                    "model": "mimo-v2-flash",
                    "messages": [
                        {
                            "role": "system",
                            "content": "You are MiMo, an AI assistant developed by Xiaomi. Today is date: Tuesday, December 16, 2025. Your knowledge cutoff date is December 2024. Answer in Chinese"
                        },
                        {
                            "role": "user",
                            "content": "请问你是什么模型？"
                        }
                    ],
                    "max_completion_tokens": 1024,
                    "temperature": 0.3,
                    "top_p": 0.95,
                    "stream": false,
                    "stop": null,
                    "frequency_penalty": 0,
                    "presence_penalty": 0,
                    "thinking": {
                        "type": "disabled"
                    }
                }
                """;
        StringEntity stringEntity = new StringEntity(
                reqJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String response = EntityUtils.toString(execute.getEntity());
            System.out.println(response);
        } else {
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println("请求失败，状态码：" + statusCode);
        }
    }

}
