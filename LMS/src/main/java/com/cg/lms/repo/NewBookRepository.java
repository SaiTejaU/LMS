package com.cg.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.model.NewBook;

public interface NewBookRepository extends JpaRepository<NewBook, Long> {

}
