package com.ulrikhsergey.board_info.dao;


import com.ulrikhsergey.board_info.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<UserMessage,Integer> {
}
