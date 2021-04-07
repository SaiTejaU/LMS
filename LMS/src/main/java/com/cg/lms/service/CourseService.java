
package com.cg.lms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.lms.entity.Courses;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;


public interface CourseService {

	
	List<CoursesDTO> getAllCourses();
	public Courses createCourse(CoursesDTO coursedto);
	public ResponseEntity<Object> deleteCourseById(Integer courseId) throws CourseNotFoundException;
	public Courses updateCoursesById(Integer courseId, CoursesDTO coursedto) throws CourseNotFoundException;
	public CoursesDTO getCourseById(Integer courseId) throws CourseNotFoundException;
	public CoursesDTO getCourseByName(String name) throws CourseNotFoundException;

}
