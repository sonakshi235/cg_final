package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.Topic;
import com.cg.app.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	//GET by default
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//GET by default - get a course with a given id 
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("id")String id) {
		topicService.deleteTopic(id);
	}
}
 