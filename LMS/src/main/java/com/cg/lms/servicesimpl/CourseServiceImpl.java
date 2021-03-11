package com.cg.lms.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Courses;

import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;
import com.cg.lms.entity.Book;
import com.cg.lms.repository.CourseRepository;
import com.cg.lms.service.CourseService;
import com.cg.lms.utils.CourseUtils;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<CoursesDTO> getAllCourses(){
		List<Courses> courses = courseRepository.findAll();
		return CourseUtils.convertToCoursesDtoList(courses);
	}
     
	@Override
	public Courses createCourse(CoursesDTO coursedto) {
		Courses course = CourseUtils.convertToCourses(coursedto);
		return courseRepository.save(course);
	}
	
	@Override
	public boolean deleteCourseById(int courseId) throws CourseNotFoundException{
		Optional<Courses> opt = courseRepository.findById((long) courseId);
		if(opt.isPresent()) {
		courseRepository.deleteById((long) courseId);
		boolean bool=false;
		 
		Courses course = courseRepository.findById((long) courseId).get();
		
		if(null==course) {
			bool = true;
		}else
			bool = false;
		
		return bool;
		}
		else throw new CourseNotFoundException("Course not found to be deleted");
	}

	@Override
	public Courses updateCoursesById(Integer courseId, List<Book> book) throws CourseNotFoundException {
		Optional<Courses> opt= courseRepository.findById((long)courseId);
		if(opt.isPresent())
		{
		Courses course = courseRepository.findById((long) courseId).get();
		course.setBooks(book);
		return courseRepository.save(course);
		}
		else {
			throw new CourseNotFoundException("Course is not present to be updated");
		}
	}
}
