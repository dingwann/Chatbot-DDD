package org.example.chatbot.domain.xiaomi.model.res;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class Completion_tokens_details {
    private String reasoning_tokens;

    public void setReasoning_tokens(String reasoning_tokens) {
        this.reasoning_tokens = reasoning_tokens;
    }

    public String getReasoning_tokens() {
        return this.reasoning_tokens;
    }
}