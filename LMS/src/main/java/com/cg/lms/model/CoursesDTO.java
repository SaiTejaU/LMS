package com.cg.lms.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.lms.entity.Book;

@Component
public class CoursesDTO {
    private long id;
    private String name;
    List<Book> book = new ArrayList<>();
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
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
}
