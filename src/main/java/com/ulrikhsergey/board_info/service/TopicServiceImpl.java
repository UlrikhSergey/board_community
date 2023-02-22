package com.ulrikhsergey.board_info.service;

import com.ulrikhsergey.board_info.dao.TopicRepository;
import com.ulrikhsergey.board_info.entity.Topic;
import com.ulrikhsergey.board_info.entity.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    TopicRepository topicRepository;
    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }

    @Override
    public Topic getTopic(int id) {
       return topicRepository.findById(id).get();
    }
}
