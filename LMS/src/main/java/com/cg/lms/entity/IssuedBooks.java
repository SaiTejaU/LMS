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
	private long bookId;
	@Column(name="bookname")
	private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
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
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long l) {
		this.bookId = l;
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
