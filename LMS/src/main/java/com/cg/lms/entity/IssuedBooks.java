package com.cg.lms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="issuedbooks")
@Table(name="issuedbooks")
public class IssuedBooks {
	@Id
	@Column(name="bookid",unique=true)
	private String bookId;
	@Column(name="userid")
	private String userId;
	@Column(name="dateissued")
	private String dateIssued;
	@Column(name="penalty")
	private Double penalty;
	public Double getPenalty() {
		return penalty;
	}
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
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
}
