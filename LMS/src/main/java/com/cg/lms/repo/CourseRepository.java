package com.cg.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
