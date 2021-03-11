package com.cg.lms.model;

import org.springframework.stereotype.Component;

@Component
public class RequestedBookDTO {
   
	private long id;
	private String name;
	private String authorname;
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
	public String getAuthorName() {
		return authorname;
	}
	public void setAuthorName(String authorname) {
		this.authorname = authorname;
	}
}

