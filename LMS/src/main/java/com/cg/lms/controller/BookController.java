package com.cg.lms.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.Book;

import com.cg.lms.services.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	       	
	@GetMapping(value="/getAllBooks")
	public List<com.cg.lms.Book> getAllBooks()
	{
		return  bookService.listAll();
	}

	@GetMapping(value="/books/{name}")
	public List<Book> getBookByBookName(@PathVariable String name)
	{
		return bookService.getBookByBookName(name);
	}	
	@GetMapping(value="/books/{id}")
	public List<Book> getBookByBookId(@PathVariable Integer id)
	{
		return bookService.getBookByBookId(id);
	}
	@GetMapping(value="/books/{authorName}")
	public List<Book> getBookByBookAuthorName(@PathVariable String authorName)
	{
		return bookService.getBookByAuthorName(authorName);
	}
	
	
}
