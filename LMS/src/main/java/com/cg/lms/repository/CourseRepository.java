package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
