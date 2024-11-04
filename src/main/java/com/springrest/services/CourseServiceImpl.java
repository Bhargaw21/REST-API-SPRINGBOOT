package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	/*List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145 , "java course" , "this Course is created for understanding java core concepts"));
		list.add(new Course(146 , "python" , "a course designed for undertanding pyhton from basic to advanced"));
	}
*/


	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}



	@Override
	public Course getCourse(Long courseId) {
		/*Course c = null;
		
		for(Course course:list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}	
		}
		*/
		return courseDao.getOne(courseId);
	}



	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}



	@Override
	public Course updateCourse(Long courseId, Course courseDetails) {
		/*Course c = getCourse(courseId);
		c.setTitle(courseDetails.getTitle());
		c.setDescription(courseDetails.getDescription());
		return c;*/
		
	        Optional<Course> optionalCourse = courseDao.findById(courseId);

	        if (optionalCourse.isPresent()) {
	            Course course = optionalCourse.get();
	            course.setTitle(courseDetails.getTitle());
	            course.setDescription(courseDetails.getDescription());
	            
	            // Save the updated course back to the database
	            return courseDao.save(course);
	        } else {
	            throw new RuntimeException("Course with ID " + courseId + " not found");
	        }
	    }
	


	 @Override
	    public String deleteCourse(Long courseId) {
	       /* Course course = getCourse(courseId);
	        if (course != null) {
	           // list.remove
	            return "Course with ID " + courseId + " deleted successfully.";
	        } else {
	            return "Course with ID " + courseId + " not found.";
	        }*/
		 
		 Optional<Course> optionalCourse = courseDao.findById(courseId);

		    if (optionalCourse.isPresent()) {
		        courseDao.delete(optionalCourse.get());
		        return "Course with ID " + courseId + " deleted successfully.";
		    } else {
		        throw new RuntimeException("Course with ID " + courseId + " not found.");
		    }
		 
	    }
	}

	


