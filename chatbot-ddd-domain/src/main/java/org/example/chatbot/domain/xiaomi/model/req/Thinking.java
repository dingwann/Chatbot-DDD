package org.example.chatbot.domain.xiaomi.model.req;

import lombok.Builder;

/**
 * @author wangcai
 * @description 知识星球API
 * @date 2025/12/21
 */
@Builder
public class Thinking {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}