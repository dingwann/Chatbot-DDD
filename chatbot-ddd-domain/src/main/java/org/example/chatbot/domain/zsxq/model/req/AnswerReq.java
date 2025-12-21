package org.example.chatbot.domain.zsxq.model.req;

/**
 * @author wangcai
 * @description 提问回答请求类
 * @date 2025/12/21
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq() {
    }
    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
