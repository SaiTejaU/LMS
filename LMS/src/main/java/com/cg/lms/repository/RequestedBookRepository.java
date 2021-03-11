package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.lms.entity.RequestedBook;
public interface RequestedBookRepository extends JpaRepository<RequestedBook, Long> {

}
