package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.lms.Book;


public interface BookRepository extends JpaRepository<Book, String> {
	@Query("select b from books b where b.name=?1")
	public List<Book> findByBookName(String bookName);
	@Query("select b from books b where b.id=?1")
	public List<Book> findByBookId(Integer id);
	@Query("select b from books b where b.authorname=?1")
	public List<Book> findByAuthorName(String authorName);


	
}
