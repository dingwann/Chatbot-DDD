package org.example.chatbot.domain.zsxq.model.aggregate;

import org.example.chatbot.domain.zsxq.model.res.RespData;

/**
 * @author wangcai
 * @description 未回答问题的聚合类
 * @date 2025/12/21
 */
public class UnAnsweredQuestionsAggregate {

    private boolean succeeded;

    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
