
package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Courses;

import com.cg.lms.entity.RequestedBook;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.entity.CourseBooks;
import com.cg.lms.service.CourseService;

import com.cg.lms.service.RequestedBookService;


@RestController
@RequestMapping("/courses")
public class CourseController {

	private static final Logger logger = LogManager.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private RequestedBookService newbookservice;
	
	
	
	@GetMapping("/")
	public List<CoursesDTO> getAllCourses(){
		
		logger.info("entered in get all courses");
		return courseService.getAllCourses();
	 }
	
	@PostMapping("/createcourse")
	public Courses createCourse(@RequestBody CoursesDTO coursedto) {
		logger.info("Entered controller create course");
		 return courseService.createCourse(coursedto);
	}
	
	@GetMapping("/newbook")
	public List<RequestedBookDTO> getAllRequestedBooks(){
		logger.info("Entered controller  get all requested books");
		
		return  newbookservice.getAllRequestedBooks();
	 }
	
	@PostMapping("/createnewbook")
	public RequestedBook requestNewBook(@RequestBody RequestedBookDTO newbookdto) {
		logger.info("Entered controller request new book");
		 return newbookservice.requestNewBook(newbookdto);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<Object> deleteCourseById(@PathVariable Integer courseId) throws CourseNotFoundException{
		logger.info("Entered controller delete course");
		return courseService.deleteCourseById(courseId);
	}
	
	@PutMapping("/updatecourse/{courseId}")
    public Courses updateCourse(@PathVariable Integer courseId, @RequestBody List<CourseBooks> coursebook) throws CourseNotFoundException{
		logger.info("Entered controller update course");
		return courseService.updateCoursesById(courseId,coursebook);
    }
	

}
