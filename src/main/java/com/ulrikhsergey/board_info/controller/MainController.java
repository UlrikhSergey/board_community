package com.ulrikhsergey.board_info.controller;

import com.ulrikhsergey.board_info.dao.TopicRepository;
import com.ulrikhsergey.board_info.entity.Topic;
import com.ulrikhsergey.board_info.entity.UserMessage;
import com.ulrikhsergey.board_info.service.MessageService;
import com.ulrikhsergey.board_info.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {
    @Autowired
    MessageService messageService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String indexPage (){
        return "index.html";
    }



    @RequestMapping("/addNewTopic")
    public String addNewTopic(Model model){
        Topic topic = new Topic();
        model.addAttribute("topic",topic);
        return "topic.html";
    }


    @PostMapping("/saveNewMessage")
    public String saveMessage(@RequestParam(name = "name") String name,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "message") String message){
        UserMessage userMessage = new UserMessage(name,email,message);
        messageService.saveMessage(userMessage);
        return "redirect:/";
    }


}
