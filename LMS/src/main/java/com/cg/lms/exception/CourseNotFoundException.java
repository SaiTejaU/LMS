package com.cg.lms.exception;

@SuppressWarnings("serial")
public class CourseNotFoundException extends Exception {
      
	  public CourseNotFoundException(String msg) {
		  super(msg);
	  }
}