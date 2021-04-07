package com.cg.lms.model;


import org.springframework.stereotype.Component;



@Component
public class CoursesDTO {
    private long id;
    private String name;
    private String textBook;
    private String refBook;
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
	public String getTextBook() {
		return textBook;
	}
	public void setTextBook(String textBook) {
		this.textBook = textBook;
	}
	public String getRefBook() {
		return refBook;
	}
	public void setRefBook(String refBook) {
		this.refBook = refBook;
	}
	
	
	
	
}

