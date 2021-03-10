package com.cg.lms.services;

import java.util.List;

import com.cg.lms.model.Book;
import com.cg.lms.model.Courses;

public interface CourseService {

	
	Iterable<Courses> getAllCourses();
	Courses createCourse(Courses course);
	boolean deleteCourseById(int courseId);
	Courses updateCoursesById(Integer courseId, List<Book> book);

}
