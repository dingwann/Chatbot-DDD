package org.example.chatbot.domain.xiaomi.model.res;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class Choices {
    private String finish_reason;

    private String index;

    private Message message;

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public String getFinish_reason() {
        return this.finish_reason;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return this.index;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }
}
