package com.cg.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.TopicRepository;
import com.cg.app.model.Topic;


@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
		
	//fetches all the topics 
	public List<Topic> getAllTopics(){
		List<Topic> ts = new ArrayList<>();
		//Uses method reference here
		topicRepository.findAll().forEach(ts::add);
		return ts;
	}
	
	//Fetches a single topic
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	//Creates a new topic
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	//Update a given topic if exists 
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);	
		
	}
	
	//delete a particular topic with a given id
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
