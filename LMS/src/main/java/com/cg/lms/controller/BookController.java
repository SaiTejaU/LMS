package com.cg.lms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.exception.BookNotIssuedError;
import com.cg.lms.exception.NoBooksLeftException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.servicesimpl.BookServiceImpl;

@RestController
@RequestMapping("/library")
public class BookController {
	@Autowired
	private BookServiceImpl service; 
	@GetMapping("/check")
	public String check(){
		return "WORKING!!!";
	}
	@GetMapping("/getallbooks")
	public List<BookDTO> getBooks(){
		return service.getBooks();
	}
	@PostMapping("/addnewbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookdto) {
		service.addBook(bookdto);
		return new ResponseEntity<>("Book added successfully!", HttpStatus.OK);
	}
	@PostMapping("/addmultiplebooks")
	public ResponseEntity<String> addMultipleBooks(@RequestBody List<BookDTO> bookdto) {
		service.addMultipleBooks(bookdto);
		return new ResponseEntity<>("Books added successfully!", HttpStatus.OK);
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
	@GetMapping(value="/getbookissued/{bname}")
	public ResponseEntity<IssuedBooksDTO> getBookIssued(@PathVariable("bname") String name) throws BookNotFoundException, NoBooksLeftException
	{
		IssuedBooksDTO issuedbookdto = service.getBookIssued(name);
		return new ResponseEntity<>(issuedbookdto, HttpStatus.OK);
	}
	@GetMapping(value="/returnbook/{bookname}")
	public ResponseEntity<String> returnBook(@PathVariable("bookname")String bookname) throws BookNotIssuedError
	{
		return new ResponseEntity<>(service.returnBook(bookname),HttpStatus.OK);	
	}
}