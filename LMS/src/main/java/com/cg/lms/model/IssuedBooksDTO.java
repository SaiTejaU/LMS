package com.cg.lms.model;


import org.springframework.stereotype.Component;

@Component
public class IssuedBooksDTO {
	private String bookId;
	private String userId;
	private String dateIssued;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String string) {
		this.bookId = string;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
}
