package com.cg.lms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Book;
import com.cg.lms.entity.RequestedBook;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.exception.BookNotIssuedError;
import com.cg.lms.exception.NoBooksLeftException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.service.BookService;
import com.cg.lms.service.RequestedBookService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins="http://localhost:3000")
public class BookController {
	@Autowired
	private BookService service; 

	@Autowired
	private RequestedBookService requestedbookservice;
	
	@GetMapping("/checkrequests")
	public List<RequestedBookDTO> getAllRequestedBooks(){
		
		return  requestedbookservice.getAllRequestedBooks();
	 }
	@PostMapping("/requestnewbook")
	public RequestedBook requestNewBook(@RequestBody RequestedBookDTO newbookdto) {
		 return requestedbookservice.requestNewBook(newbookdto);
	}
	@GetMapping("/getallbooks")
	public List<BookDTO> getBooks(){
		return service.getBooks();
	}
	@DeleteMapping("/handlerequest/{Id}")
    public ResponseEntity<Object> handleRequest(@PathVariable("Id") Long Id){
        return requestedbookservice.handleRequest(Id);
    }
	@PostMapping("/addnewbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookdto) {
		service.addBook(bookdto);
		return new ResponseEntity<>("Book added successfully!", HttpStatus.OK);
	}
	@PutMapping("/updatebook")
    public ResponseEntity<Object> updateBook(@RequestBody BookDTO bookdto) throws BookNotFoundException {
    	Book book=service.updateBook(bookdto);
    	return new ResponseEntity<>(book, HttpStatus.OK);
    }
	@PostMapping("/addmultiplebooks")
	public ResponseEntity<String> addMultipleBooks(@RequestBody List<BookDTO> bookdto) {
		service.addMultipleBooks(bookdto);
		return new ResponseEntity<>("Books added successfully!", HttpStatus.OK);
	}
	
	@GetMapping(value="/getbyid/{id}")
	public ResponseEntity<BookDTO> getBookbyId(@PathVariable("id")Long bookId) throws BookNotFoundException{
		BookDTO bookdto=service.getBookById(bookId);
		return new ResponseEntity<>(bookdto, HttpStatus.OK);
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
	@GetMapping(value="/getbookissued/{id}")
	public ResponseEntity<IssuedBooksDTO> getBookIssued(@PathVariable("id") Long id) throws BookNotFoundException, NoBooksLeftException
	{
		IssuedBooksDTO issuedbookdto = service.getBookIssued(id);
		return new ResponseEntity<>(issuedbookdto, HttpStatus.OK);
	}
	@GetMapping(value="/returnbook/{bookname}")
	public ResponseEntity<String> returnBook(@PathVariable("bookname")String bookname) throws BookNotIssuedError
	{
		return new ResponseEntity<>(service.returnBook(bookname),HttpStatus.OK);	
	}
}