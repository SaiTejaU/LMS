package com.cg.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="booktable")
@Table(name="booktable")
public class Book {
	@Id
	@Column(name="bookid",unique=true)
	private String bookId;
	@Column(name="bookname")
	private String bookName;
	@Column(name="authorname")
	private String authorName;
	@Column(name="bookdescription")
	private String bookDescription;
	@Column(name="bookcount")
	private Integer bookCount;
	@Column(name="isavailable")
	private String isAvailable;
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public String isAvailable() {
		return isAvailable;
	}
	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Book(String bookId, String bookName, String authorName, String bookDescription, Integer bookCount,
			String isAvailable) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookDescription = bookDescription;
		this.bookCount = bookCount;
		this.isAvailable = isAvailable;
	}
	public Book() {
		super();
	}
	
}
