package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.lms.entity.IssuedBooks;

@Repository
public interface IssuedBooksRepository  extends JpaRepository<IssuedBooks,String>{
	
}
