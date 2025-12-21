package org.example.chatbot.domain.xiaomi.model.req;

import lombok.Builder;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
@Builder
public class Messages {
    private String role;

    private String content;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
