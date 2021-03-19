package com.cg.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.app.model.Course;

public interface CourseRepository extends JpaRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId); 
}
