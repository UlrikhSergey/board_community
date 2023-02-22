package com.ulrikhsergey.board_info.service;

import com.ulrikhsergey.board_info.dao.MessageRepository;
import com.ulrikhsergey.board_info.entity.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository repository;

    @Override
    public void saveMessage(UserMessage userMessage) {
        repository.save(userMessage);
    }

    @Override
    public List<UserMessage> getAllUserMessages() {
        return repository.findAll();
    }

    @Override
    public void deleteUserMessage(int id) {
        repository.deleteById(id);
    }

    @Override
    public UserMessage getUserMessage(int id) {
        return repository.findById(id).get();
    }


}
