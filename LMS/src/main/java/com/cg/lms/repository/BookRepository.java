package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT n FROM booktable n WHERE n.bookName = :name")
	Book findByName(String name);
    @Query("select b from booktable b where b.authorName=:authorName")
	Book findByAuthorName(String authorName);

}
