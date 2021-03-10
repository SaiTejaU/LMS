package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Courses;
import com.cg.lms.entity.Book;

public interface CourseService {

	
	Iterable<Courses> getAllCourses();
	Courses createCourse(Courses course);
	boolean deleteCourseById(int courseId);
	Courses updateCoursesById(Integer courseId, List<Book> book);

}
