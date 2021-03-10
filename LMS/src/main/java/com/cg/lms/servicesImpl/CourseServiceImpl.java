package com.cg.lms.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Courses;
import com.cg.lms.entity.Book;
import com.cg.lms.repository.CourseRepository;
import com.cg.lms.service.CourseService;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Iterable<Courses> getAllCourses(){
		return courseRepository.findAll();
	}
     
	@Override
	public Courses createCourse(Courses course) {
		return courseRepository.save(course);
	}
	
	@Override
	public boolean deleteCourseById(int courseId) {
		courseRepository.deleteById((long) courseId);
		Courses course = courseRepository.findById((long) courseId).get();
		boolean bool;
		if(null==course) {
			bool = true;
		}else
			bool = false;
		
		return bool;
	}

	@Override
	public Courses updateCoursesById(Integer courseId, List<Book> book) {
		Courses course = courseRepository.findById((long) courseId).get();
		course.setBooks(book);
		return courseRepository.save(course);
	}
}
