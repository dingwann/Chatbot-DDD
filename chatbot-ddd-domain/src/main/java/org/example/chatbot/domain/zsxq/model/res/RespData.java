package org.example.chatbot.domain.zsxq.model.res;

import org.example.chatbot.domain.zsxq.model.vo.Topic;

import java.util.List;

/**
 * @author wangcai
 * @description 请求的结果数据
 * @date 2025/12/21
 */
public class RespData {

    private List<Topic> topics;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
