package org.example.chatbot.domain.xiaomi.model.res;

/**
 * @author wangcai
 * @description Xiaomi MIMO
 * @date 2025/12/21
 */
public class Message {
    private String content;

    private String role;

    private String tool_calls;

    private String reasoning_content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setTool_calls(String tool_calls) {
        this.tool_calls = tool_calls;
    }

    public String getTool_calls() {
        return this.tool_calls;
    }

    public void setReasoning_content(String reasoning_content) {
        this.reasoning_content = reasoning_content;
    }

    public String getReasoning_content() {
        return this.reasoning_content;
    }
}