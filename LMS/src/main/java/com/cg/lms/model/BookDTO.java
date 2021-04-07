package com.cg.lms.model;

import org.springframework.stereotype.Component;

@Component
public class BookDTO {
	private long bookId;
	private String bookName;
	private String authorName;
	private String bookDescription;
	private Integer bookCount;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
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
}
