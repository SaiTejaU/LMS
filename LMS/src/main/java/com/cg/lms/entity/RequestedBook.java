package com.cg.lms.entity;

import javax.persistence.*;


@Entity(name = "newbooks")
public class RequestedBook {

	public RequestedBook() {}
	public RequestedBook(String name, String authorName) {
		super();
		this.name = name;
		this.authorName = authorName;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


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
