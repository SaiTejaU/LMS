package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Courses;

import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.CoursesDTO;

import com.cg.lms.service.CourseService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/courses")
public class CourseController {

	private static final Logger logger = LogManager.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	
	
	
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
	
	@GetMapping("/getbyname/{cname}")
	public ResponseEntity<CoursesDTO> getCoursebyName(@PathVariable("cname")String name) throws CourseNotFoundException{
		CoursesDTO coursedto=courseService.getCourseByName(name);
		return new ResponseEntity<>(coursedto, HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{cid}")
	public ResponseEntity<CoursesDTO> getCoursebyId(@PathVariable("cid")Integer courseId) throws CourseNotFoundException{
		CoursesDTO coursedto=courseService.getCourseById(courseId);
		return new ResponseEntity<>(coursedto, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<Object> deleteCourseById(@PathVariable Integer courseId) throws CourseNotFoundException{
		logger.info("Entered controller delete course");
		return courseService.deleteCourseById(courseId);
	}
	
	@PutMapping("/updatecourse/{courseId}")
    public Courses updateCourse(@PathVariable Integer courseId, @RequestBody CoursesDTO course) throws CourseNotFoundException{
		logger.info("Entered controller update course");
		return courseService.updateCoursesById(courseId,course);
    }
	

}
