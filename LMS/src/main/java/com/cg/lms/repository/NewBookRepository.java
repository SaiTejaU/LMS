package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.NewBook;

public interface NewBookRepository extends JpaRepository<NewBook, Long> {

}
