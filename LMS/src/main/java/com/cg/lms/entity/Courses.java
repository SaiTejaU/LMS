package com.cg.lms.entity;

import javax.persistence.*;


@Entity(name="courses")
@Table(name ="courses")
public class Courses {

	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "course_name")
	private String name;
	
	@Column
	private String textBook;
	
	@Column
	private String refBook;
	
	public Courses() {
	
	
}
	public Courses(String name, Long id, String textBook, String refBook) {
		this.name = name;
		this.id=id;
		this.textBook=textBook;
		this.refBook = refBook;
	}
	
	 public long getId() {
	        return id;
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
		public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
		
	
	
}
