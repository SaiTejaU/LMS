package com.cg.lms.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User,String>{
	@Query("select u from User u where u.email=:email")
    User findByEmail(String email);
	@Query("select u from User u where u.userId like :student%")
    List<User> getAllStudents(String student);
	@Query("select u from User u where u.userId like :instructor%")
    List<User> getAllInstructors(String instructor);
	@Query("select u from User u where u.userId like :librarian%")
    List<User> getAllLibrarians(String librarian);
	
}