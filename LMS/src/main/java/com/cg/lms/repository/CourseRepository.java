package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.lms.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {
	@Query("SELECT n FROM courses n WHERE n.name = :name")
	Courses findByName(String name);
}
