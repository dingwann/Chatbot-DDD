package org.example.chatbot.domain.zsxq.model.vo;

/**
 * @author wangcai
 * @description 知识星球响应类
 * @date 2025/12/21
 */
public class Owner_detail {
    private String questions_count;

    private String join_time;

    private String status;

    public void setQuestions_count(String questions_count) {
        this.questions_count = questions_count;
    }

    public String getQuestions_count() {
        return this.questions_count;
    }

    public void setJoin_time(String join_time) {
        this.join_time = join_time;
    }

    public String getJoin_time() {
        return this.join_time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}