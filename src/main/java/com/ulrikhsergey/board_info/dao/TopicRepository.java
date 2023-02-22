package com.ulrikhsergey.board_info.dao;

import com.ulrikhsergey.board_info.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {
}
