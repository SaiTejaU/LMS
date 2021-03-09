package com.cg.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT n FROM booktable n WHERE n.bookName = ?1")
	Optional<Book> findByName(String name);

	@Query("SELECT n FROM booktable n WHERE n.bookName = ?1")
	void deleteByName(String name);


}
