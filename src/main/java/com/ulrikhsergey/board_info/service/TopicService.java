package com.ulrikhsergey.board_info.service;

import com.ulrikhsergey.board_info.entity.Topic;
import com.ulrikhsergey.board_info.entity.UserMessage;

import java.util.List;

public interface TopicService {
    public List<Topic> getAllTopics();
    public void saveTopic (Topic topic);
    public void deleteTopic(int id);
    public Topic getTopic(int id);
}
