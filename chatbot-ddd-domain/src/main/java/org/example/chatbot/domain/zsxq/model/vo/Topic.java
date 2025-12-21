package org.example.chatbot.domain.zsxq.model.vo;

/**
 * @author wangcai
 * @description 知识星球响应类
 * @date 2025/12/21
 */
public class Topic {
    private String topic_id;

    private String topic_uid;

    private Group group;

    private String type;

    private Question question;

    private Answer answer;

    private boolean answered;

    private boolean silenced;

    private String likes_count;

    private String tourist_likes_count;

    private String rewards_count;

    private String comments_count;

    private String reading_count;

    private String readers_count;

    private boolean digested;

    private boolean sticky;

    private String create_time;

    private User_specific user_specific;

    private String title;

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_uid(String topic_uid) {
        this.topic_uid = topic_uid;
    }

    public String getTopic_uid() {
        return this.topic_uid;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return this.group;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean getAnswered() {
        return this.answered;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }

    public boolean getSilenced() {
        return this.silenced;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getLikes_count() {
        return this.likes_count;
    }

    public void setTourist_likes_count(String tourist_likes_count) {
        this.tourist_likes_count = tourist_likes_count;
    }

    public String getTourist_likes_count() {
        return this.tourist_likes_count;
    }

    public void setRewards_count(String rewards_count) {
        this.rewards_count = rewards_count;
    }

    public String getRewards_count() {
        return this.rewards_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getComments_count() {
        return this.comments_count;
    }

    public void setReading_count(String reading_count) {
        this.reading_count = reading_count;
    }

    public String getReading_count() {
        return this.reading_count;
    }

    public void setReaders_count(String readers_count) {
        this.readers_count = readers_count;
    }

    public String getReaders_count() {
        return this.readers_count;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }

    public boolean getDigested() {
        return this.digested;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public boolean getSticky() {
        return this.sticky;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setUser_specific(User_specific user_specific) {
        this.user_specific = user_specific;
    }

    public User_specific getUser_specific() {
        return this.user_specific;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
