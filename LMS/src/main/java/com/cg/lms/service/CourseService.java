package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Courses;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;
import com.cg.lms.entity.Book;

public interface CourseService {

	
	List<CoursesDTO> getAllCourses();
	Courses createCourse(CoursesDTO coursedto);
	boolean deleteCourseById(int courseId) throws CourseNotFoundException;
	Courses updateCoursesById(Integer courseId, List<Book> book) throws CourseNotFoundException;

}
