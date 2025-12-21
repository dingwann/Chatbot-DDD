package org.example.chatbot.domain.xiaomi.model.res;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class Usage {
    private String completion_tokens;

    private String prompt_tokens;

    private String total_tokens;

    private Completion_tokens_details completion_tokens_details;

    private Prompt_tokens_details prompt_tokens_details;

    public void setCompletion_tokens(String completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public String getCompletion_tokens() {
        return this.completion_tokens;
    }

    public void setPrompt_tokens(String prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public String getPrompt_tokens() {
        return this.prompt_tokens;
    }

    public void setTotal_tokens(String total_tokens) {
        this.total_tokens = total_tokens;
    }

    public String getTotal_tokens() {
        return this.total_tokens;
    }

    public void setCompletion_tokens_details(Completion_tokens_details completion_tokens_details) {
        this.completion_tokens_details = completion_tokens_details;
    }

    public Completion_tokens_details getCompletion_tokens_details() {
        return this.completion_tokens_details;
    }

    public void setPrompt_tokens_details(Prompt_tokens_details prompt_tokens_details) {
        this.prompt_tokens_details = prompt_tokens_details;
    }

    public Prompt_tokens_details getPrompt_tokens_details() {
        return this.prompt_tokens_details;
    }
}