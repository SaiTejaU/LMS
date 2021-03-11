package com.cg.lms.controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.service.BookService;

@RestController
@RequestMapping("/library")
public class BookController {
	private static final Logger logger = LogManager.getLogger(BookController.class);
	@Autowired
	BookService service;
	
	@GetMapping("/getallbooks")
	public ResponseEntity<List<BookDTO>> getBooks(){
		logger.info("Logger Implemented");
		List<BookDTO> booklist = service.getBooks();
		return new ResponseEntity<>(booklist, HttpStatus.OK);
	}
	@RequestMapping("/check")
	public String greet()
	{
		return "<h2>working working !!!!!!!!!</h2>";
	}
	
	@PostMapping("/addnewbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookdto) {
		service.addBook(bookdto);
		return new ResponseEntity<>("Book added successfully!", HttpStatus.OK);
	}
	@DeleteMapping("/deletebook/{dname}")
	public ResponseEntity<Object> deleteBook(@PathVariable("dname")String name) throws BookNotFoundException
	{
		return service.deleteBookByName(name);
	}
	@GetMapping(value="/getbyname/{pname}")
	public ResponseEntity<BookDTO> getBookbyName(@PathVariable("pname")String name) throws BookNotFoundException{
		BookDTO bookdto=service.getBookByname(name);
		return new ResponseEntity<>(bookdto, HttpStatus.OK);
	}
	@GetMapping(value="/getbyauthor/{authorName}")
	public BookDTO getBookByBookAuthorName(@PathVariable String authorName) throws BookNotFoundException
	{
		return service.getBookByAuthorName(authorName);
	}
}
