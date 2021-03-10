package com.cg.lms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookm")
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String bookName;
	
	@Column(name = "authorname")
	private String authorname;

	public Integer getBookId() {
		return id;
	}

	public void setBookId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorname;
	}

	public void setAuthorName(String authorname) {
		this.authorname = authorname;
	}
public Book()
{
	super();
}
 public Book(Integer id,String name,String authorname)
 {
	 super();
	 this.id=id;
	 this.authorname=authorname;
	 this.authorname=name;
 }
}
