package com.ulrikhsergey.board_info.controller;

import com.ulrikhsergey.board_info.entity.Topic;
import com.ulrikhsergey.board_info.entity.UserMessage;
import com.ulrikhsergey.board_info.service.MessageService;
import com.ulrikhsergey.board_info.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * рест - сервис для администратора
 */
@RestController
public class RestAdminController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private TopicService topicService;

    //Просмотр всех сообщений из формы обратной связи
    @GetMapping("/messages")
    public List<UserMessage> getAllUserMessages(Model model){
        List<UserMessage> allUserMessages = messageService.getAllUserMessages();
        model.addAttribute("allUserMessages", allUserMessages);
        return allUserMessages;
    }

    //Просмотр сообщения по id из формы обратной связи
    @GetMapping("/messages/{id}")
    public UserMessage getUserMessage(@PathVariable int id){
        UserMessage userMessage = messageService.getUserMessage(id);
        return userMessage;
    }

    //Удаление сообщения по определенному id
    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable int id){
        UserMessage userMessage = messageService.getUserMessage(id);
        messageService.deleteUserMessage(id);
        return "Message with id = " + id + " was deleted";
    }
    //Просмотр всех сообщений из чата
    @GetMapping("/chatmessages")
    public List<Topic> getAllTopics(Model model){
        List<Topic> allTopics = topicService.getAllTopics();
        model.addAttribute("allTopics", allTopics);
        return allTopics;
    }

    //Просмотр сообщения по id из чата
    @GetMapping("/chatmessages/{id}")
    public Topic getTopic(@PathVariable int id){
        Topic topic = topicService.getTopic(id);
        return topic;
    }

    //Удаление сообщения по определенному id из чата
    @DeleteMapping("/chatmessages/{id}")
    public String deleteTopic(@PathVariable int id){
        Topic topic = topicService.getTopic(id);
        topicService.deleteTopic(id);
        return "Topic with id = " + id + " was deleted";
    }

}
