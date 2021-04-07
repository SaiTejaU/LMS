package com.cg.lms.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Courses;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;

import com.cg.lms.repository.CourseRepository;
import com.cg.lms.service.CourseService;
import com.cg.lms.utils.CourseUtils;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	private static final Logger logger = LogManager.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<CoursesDTO> getAllCourses(){
		logger.info("entered service in get all courses");
		List<Courses> courses = courseRepository.findAll();
		return CourseUtils.convertToCoursesDtoList(courses);
	}
     
	@Override
	public Courses createCourse(CoursesDTO coursedto) {
		logger.info("entered service in create courses");
		Courses course = CourseUtils.convertToCourses(coursedto);
		return courseRepository.save(course);
	}
	
	@Override
	public ResponseEntity<Object> deleteCourseById(Integer userId) throws CourseNotFoundException {
		logger.info("entered service in delete courses");
		long courseID = (long) userId;
		return courseRepository.findById(courseID).map(course ->{
    		courseRepository.delete(course);
    		return ResponseEntity.ok().build();
    	}).orElseThrow(()-> new CourseNotFoundException("CourseId "+courseID+" not found"));
    }

/*	@Override
	public Courses updateCoursesById(Integer courseId, List<CourseBooks> coursebook) throws CourseNotFoundException {
		logger.info("entered service in get all courses");
		Optional<Courses> opt= courseRepository.findById((long)courseId);
		
		if(opt.isPresent())
		{
		Courses course = courseRepository.findById((long) courseId).get();
		course.setCoursebook(coursebook);
		return courseRepository.save(course);
		}
		else {
			throw new CourseNotFoundException("Course is not present to be updated");
		}
	} */

	@Override
	public Courses updateCoursesById(Integer courseId,CoursesDTO coursedto ) throws CourseNotFoundException {
		
		logger.info("entered service in get all courses");
		Optional<Courses> opt= courseRepository.findById((long)courseId);
		Courses course = new Courses();
		if(opt.isPresent())
		{
		  course.setId(coursedto.getId());
		  course.setName(coursedto.getName());
		  course.setTextBook(coursedto.getTextBook());
		  course.setRefBook(coursedto.getRefBook());
		  return courseRepository.save(course);
		}
		else {
			throw new CourseNotFoundException("Course is not present to be updated");
		}
		
	}

	@Override
	public CoursesDTO getCourseById(Integer courseId) throws CourseNotFoundException{
		Optional<Courses> opt= courseRepository.findById((long)courseId);		
		if(opt.isPresent()) {
			Courses course= opt.get();
			return CourseUtils.convertToCoursesDto(course);
		}
		else {
			throw new CourseNotFoundException("Course not found for the given courseId");			
		}
	
	}

	@Override
	public CoursesDTO getCourseByName(String name) throws CourseNotFoundException{
		Courses course = courseRepository.findByName(name);		
	    if(course == null) {
	    	throw new CourseNotFoundException("Course not found for the given course name");
	    }else
	    {
	    	return CourseUtils.convertToCoursesDto(course);
	    }
	
	}
}

