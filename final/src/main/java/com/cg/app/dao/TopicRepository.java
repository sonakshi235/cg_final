package com.cg.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.Topic;


public interface TopicRepository extends JpaRepository<Topic, String>{

}
