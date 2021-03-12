package com.cg.lms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.lms.entity.Courses;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;
import com.cg.lms.entity.CourseBooks;

public interface CourseService {

	
	List<CoursesDTO> getAllCourses();
	Courses createCourse(CoursesDTO coursedto);
	public ResponseEntity<Object> deleteCourseById(Integer courseId) throws CourseNotFoundException;
	Courses updateCoursesById(Integer courseId, List<CourseBooks> coursebook) throws CourseNotFoundException;
	public List<Courses> addMultipleCourses(List<CoursesDTO> coursesdto);
}