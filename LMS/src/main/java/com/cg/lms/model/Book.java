package com.cg.lms.model;

import javax.persistence.*;


@Entity(name = "books")
public class Book {

	public Book() {}
	public Book(String name, String authorName) {
		super();
		this.name = name;
		this.authorName = authorName;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name="author")
	private String authorName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}