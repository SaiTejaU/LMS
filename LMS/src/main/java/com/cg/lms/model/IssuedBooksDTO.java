package com.cg.lms.model;


import org.springframework.stereotype.Component;

@Component
public class IssuedBooksDTO {
	private String bookId;
	private String userId;
	private String dateIssued;
	private Double penalty;
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
	public Double getPenalty() {
		return penalty;
	}
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}
}
