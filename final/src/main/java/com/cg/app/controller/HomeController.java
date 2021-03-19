package com.cg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.app.model.Topic;
import com.cg.app.service.CourseService;
import com.cg.app.service.TopicService;

@RequestMapping("/")
@Controller
public class HomeController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public ModelAndView fetchTopics() {
		return new ModelAndView("viewTopics","TopicList",topicService.getAllTopics());
	}

	@GetMapping("/1")
	public String fetchcourse1() {
		return "course";
	}
	@GetMapping("/2")
	public String fetchcourse2() {
		return "course2";
	}
	@GetMapping("/3")
	public String fetchcourse3() {
		return "course3";
	}
	@GetMapping("/4")
	public String fetchcourse4() {
		return "course4";
	}
}
