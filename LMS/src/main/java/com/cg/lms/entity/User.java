package com.cg.lms.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")

public class User {
	
	@Id	
	@Column(name = "UserId", unique = true, nullable = false)
	private String userId;
	@Column(name = "FirstName", nullable = false)
	private String fName;
	@Column(name = "LastName", nullable = false)
	private String lName;
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "ContactNo", nullable = false)
	private String contactno;	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public User() {
		super();
	}
	public User(String userId, String fName, String lName, String email, String password, String contactno) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.contactno = contactno;
	}
	
	
}


