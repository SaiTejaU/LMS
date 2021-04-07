package com.cg.lms.model;


import org.springframework.stereotype.Component;

@Component
public class IssuedBooksDTO {
	private long bookId;
	private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	private String userId;
	private String dateIssued;
	private Double penalty;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
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
