package com.cg.lms.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.model.BookDTO;
import com.cg.lms.service.BookNotFoundException;
import com.cg.lms.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getProducts(){
		List<BookDTO> booklist = service.getBooks();
		return new ResponseEntity<>(booklist, HttpStatus.OK);
	}
	@RequestMapping("/check")
	public String greet()
	{
		return "<h2>working working !!!!!!!!!</h2>";
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/books/newbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookdto) {
		service.addBook(bookdto);
		return new ResponseEntity<>("Book added successfully!", HttpStatus.OK);
	}
	@DeleteMapping("/books/{pname}")
	public String deleteBook(@PathVariable("pname")String name)
	{
		service.deleteBookByName(name);
		return "Deleted!";
	}

	@GetMapping(value="books/delete/{pname}")
	public ResponseEntity<BookDTO> getBookbyName(@PathVariable("pname")String name) throws BookNotFoundException{
		BookDTO bookdto=service.getBookByname(name);
		return new ResponseEntity<>(bookdto, HttpStatus.OK);
	}
  @GetMapping(value="/books/{authorName}")
	public List<Book> getBookByBookAuthorName(@PathVariable String authorName)
	{
		return bookService.getBookByAuthorName(authorName);
	}
}
