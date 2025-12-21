package org.example.chatbot.domain.xiaomi.model.res;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class Prompt_tokens_details {
    private String cached_tokens;

    public void setCached_tokens(String cached_tokens) {
        this.cached_tokens = cached_tokens;
    }

    public String getCached_tokens() {
        return this.cached_tokens;
    }
}