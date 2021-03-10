package com.cg.lms.entity;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "courses")
public class Courses {

	@Id
	private long id;
	
	@Column(name = "course_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cb_fk", referencedColumnName = "id")
	List<Book> books = new ArrayList<>();
	
	public Courses() {
	
	
}
	public Courses(String name, Long id) {
		this.name = name;
		this.id=id;
	}
	
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
		public List<Book> getBooks() {
			return books;
		}
		public void setBooks(List<Book> books) {
			this.books = books;
		}
	
	
}