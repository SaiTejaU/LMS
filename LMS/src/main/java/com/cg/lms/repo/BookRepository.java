package com.cg.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
