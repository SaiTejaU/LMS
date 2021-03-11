package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.lms.entity.Book;
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
		
		 return courseService.createCourse(coursedto);
	}
	
	@GetMapping("/newbook")
	public List<RequestedBookDTO> getAllRequestedBooks(){
		logger.info("Entered");
		
		return  newbookservice.getAllRequestedBooks();
	 }
	
	@PostMapping("/createnewbook")
	public RequestedBook requestNewBook(@RequestBody RequestedBookDTO newbookdto) {
		
		 return newbookservice.requestNewBook(newbookdto);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public boolean deleteCourseById(@PathVariable int courseId) throws CourseNotFoundException {
		return courseService.deleteCourseById(courseId);
	}
	
	@PutMapping("/updatecourse/{courseId}")
    public Courses createTicket(@PathVariable Integer courseId, @RequestBody List<Book> book) throws CourseNotFoundException{
        return courseService.updateCoursesById(courseId,book);
    }
	

}

