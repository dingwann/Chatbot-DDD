package org.example.chatbot.domain.zsxq;

import org.example.chatbot.domain.zsxq.model.aggregate.UnAnsweredQuestionsAggregate;

/**
 * @author wangcai
 * @description 知识星球API
 * @date 2025/12/21
 */
public interface IZsxqApi {

    UnAnsweredQuestionsAggregate queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws Exception;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws Exception;

}
