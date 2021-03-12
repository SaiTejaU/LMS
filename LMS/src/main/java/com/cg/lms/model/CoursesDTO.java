package com.cg.lms.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.lms.entity.CourseBooks;

@Component
public class CoursesDTO {
    private long id;
    private String name;
    List<CourseBooks> coursebook = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CourseBooks> getCoursebook() {
		return coursebook;
	}
	public void setCoursebook(List<CourseBooks> coursebook) {
		this.coursebook = coursebook;
	}
	
	
	
}
