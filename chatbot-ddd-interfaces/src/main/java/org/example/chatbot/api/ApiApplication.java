package org.example.chatbot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangcai
 * @description App启动入口
 * @date 2025/12/20
 */
@SpringBootApplication
@ComponentScan("org.example.chatbot")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
