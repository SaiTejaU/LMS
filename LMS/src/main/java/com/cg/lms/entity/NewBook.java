package com.cg.lms.entity;

import javax.persistence.*;


@Entity(name = "newbooks")
public class NewBook {

	public NewBook() {}
	public NewBook(String name, String authorName) {
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