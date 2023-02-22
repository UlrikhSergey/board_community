package com.ulrikhsergey.board_info.service;


import com.ulrikhsergey.board_info.entity.UserMessage;

import java.util.List;

public interface MessageService {
    public void saveMessage(UserMessage userMessage);
    public List<UserMessage> getAllUserMessages();
    public void deleteUserMessage(int id);
    public UserMessage getUserMessage(int id);
}
