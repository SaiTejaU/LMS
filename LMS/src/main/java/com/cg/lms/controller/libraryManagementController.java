package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.services.CourseService;
import com.cg.lms.services.NewBookService;
import com.cg.lms.model.*;

@RestController
@RequestMapping("/courses")
public class libraryManagementController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private NewBookService newbookservice;
	
	@GetMapping("/")
	public List<Courses> getAllCourses(){
		return (List<Courses>) courseService.getAllCourses();
	 }
	
	@PostMapping("/createcourse")
	public Courses createCourse(@RequestBody Courses course) {
		
		 return courseService.createCourse(course);
	}
	
	@GetMapping("/newbook")
	public List<NewBook> getAllNewBooks(){
		return (List<NewBook>) newbookservice.getAllNewBooks();
	 }
	
	@PostMapping("/createnewbook")
	public NewBook createNewBook(@RequestBody NewBook newbook) {
		
		 return newbookservice.createNewBook(newbook);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public boolean deleteCourseById(@PathVariable int courseId) {
		return courseService.deleteCourseById(courseId);
	}
	
	@PutMapping("/updatecourse/{courseId}")
    public Courses createTicket(@PathVariable Integer courseId, @RequestBody List<Book> book){
        return courseService.updateCoursesById(courseId,book);
    }
}
