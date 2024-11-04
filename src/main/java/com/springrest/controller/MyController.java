package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to course application";
	}
	
	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails) {
        return this.courseService.updateCourse(courseId, courseDetails);
    }
	
	 // Delete a course by ID
    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable Long courseId) {
       return  this.courseService.deleteCourse(courseId);
}
    
}