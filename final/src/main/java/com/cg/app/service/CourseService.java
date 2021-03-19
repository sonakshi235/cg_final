package com.cg.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.CourseRepository;
import com.cg.app.model.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	//Fetch all courses
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	//Fetch a single course
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	//Add a new course
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	//Update a given course
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	//Delete a course
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
	
}
