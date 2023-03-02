package com.ulrikhsergey.board_info.controller;

import com.ulrikhsergey.board_info.entity.Topic;
import com.ulrikhsergey.board_info.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChatController {
    @Autowired
    TopicService topicService;

    // Вывод всех сообщений чата
    @GetMapping("/chat")
    public String getAllTopics(Model model){
        Iterable<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics", topics);
        return "first.html";
    }

    // Отправка сообщения в чат, редирект на основную страницу со всеми сообщениями
    @PostMapping("/saveTopic")
    public String saveTopic(@RequestParam String name,
                            @RequestParam String topic,
                            @RequestParam String text){
        Topic topic1 = new Topic(name,topic,text);
        topicService.saveTopic(topic1);
        return "redirect:/chat";
    }
}
