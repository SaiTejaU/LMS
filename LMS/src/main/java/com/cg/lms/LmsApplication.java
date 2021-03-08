package com.cg.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.lms.model.Book;
import com.cg.lms.model.Courses;
import com.cg.lms.repo.CourseRepository;

@SpringBootApplication
public class LmsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	//This Block of code is to put data into the table and to check if the rows and columns get added or not
	//Uncomment this block to run the application and check if it's working or not.
	/*
 @Autowired
 private CourseRepository courseRepository;
        

@Override
public void run(String...args) throws Exception {

    Courses course = new Courses("Computer Science");

    Book book1 = new Book("Java","Sai Teja");
    Book book2 = new Book("Jpa","Monica K B");
    Book book3 = new Book("Spring Boot","Shanthiya");

    course.getBooks().add(book1);
    course.getBooks().add(book2);
    course.getBooks().add(book3);

    this.courseRepository.saveAndFlush(course);
}*/
}