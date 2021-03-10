package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.lms.Book;


public interface BookRepository extends JpaRepository<Book, String> {
	@Query("select b from Book b where b.bookName=:bookName")
	public List<Book> findByBookName(String bookName);
	@Query("select b from Book b where b.id=:id")
	public List<Book> findByBookId(Integer id);
	@Query("select b from Book b where b.authorname=:authorName")
	public List<Book> findByAuthorName(String authorName);


	
}
