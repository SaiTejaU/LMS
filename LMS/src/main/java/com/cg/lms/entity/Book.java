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
	private Integer bookId;
	@Column(name="bookname")
	private String bookName;
	@Column(name="authorname")
	private String authorName;
	@Column(name="bookdescription")
	private String bookDescription;
	@Column(name="bookcount")
	private Integer bookCount;
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookId() {
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
	public Book(Integer bookId, String bookName, String authorName, String bookDescription, Integer bookCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookDescription = bookDescription;
		this.bookCount = bookCount;
	}
	public Book() {
		super();
	}
	
}
