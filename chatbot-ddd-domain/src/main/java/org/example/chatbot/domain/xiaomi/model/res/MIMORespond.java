package org.example.chatbot.domain.xiaomi.model.res;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class MIMORespond {
    private String id;

    private List<Choices> choices;

    private String created;

    private String model;

    private String object;

    private Usage usage;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    public List<Choices> getChoices() {
        return this.choices;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return this.created;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getObject() {
        return this.object;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Usage getUsage() {
        return this.usage;
    }
}