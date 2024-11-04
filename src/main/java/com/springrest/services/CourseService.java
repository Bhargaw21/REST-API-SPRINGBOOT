package com.springrest.services;

import java.util.List;

import com.springrest.entities.Course;

public interface  CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(Long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Long courseId, Course courseDetails);

	public String deleteCourse(Long courseId);

	
	
}

