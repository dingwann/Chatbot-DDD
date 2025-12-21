package org.example.chatbot.domain.xiaomi.model.req;

import lombok.Builder;

import java.util.List;

/**
 * @author wangcai
 * @description 知识星球API
 * @date 2025/12/21
 */
@Builder
public class MIMORequest {
    private String model;

    private List<Messages> messages;

    private String max_completion_tokens;

    private double temperature;

    private double top_p;

    private boolean stream;

    private String stop;

    private String frequency_penalty;

    private String presence_penalty;

    private Thinking thinking;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Messages> getMessages() {
        return this.messages;
    }

    public void setMax_completion_tokens(String max_completion_tokens) {
        this.max_completion_tokens = max_completion_tokens;
    }

    public String getMax_completion_tokens() {
        return this.max_completion_tokens;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTop_p(double top_p) {
        this.top_p = top_p;
    }

    public double getTop_p() {
        return this.top_p;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public boolean getStream() {
        return this.stream;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getStop() {
        return this.stop;
    }

    public void setFrequency_penalty(String frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public String getFrequency_penalty() {
        return this.frequency_penalty;
    }

    public void setPresence_penalty(String presence_penalty) {
        this.presence_penalty = presence_penalty;
    }

    public String getPresence_penalty() {
        return this.presence_penalty;
    }

    public void setThinking(Thinking thinking) {
        this.thinking = thinking;
    }

    public Thinking getThinking() {
        return this.thinking;
    }
}
