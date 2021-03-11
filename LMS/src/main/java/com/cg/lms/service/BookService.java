package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Book;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.repository.BookRepository;
import com.cg.lms.utils.BookUtils;

@Service
public class BookService {
	@Autowired
	BookRepository repo;
	
	public List<BookDTO> getBooks() {
		List<Book> booklist= repo.findAll();
		return BookUtils.convertToBookDtoList(booklist);
	}
	public void addBook(BookDTO bookdto) {
		repo.save(BookUtils.convertToBook(bookdto));
	}
	public BookDTO getBookByname(String name) throws BookNotFoundException {
		Book book= repo.findByName(name);
		if(book==null) {
			throw new BookNotFoundException("No book found with the given name!");
		}
		else {
			return BookUtils.convertToBookDto(book);
		}	
	}
	public ResponseEntity<Object> deleteBookByName(String name) throws BookNotFoundException
	{
		Book tempbook=repo.findByName(name);
		if(tempbook==null)
		{
			throw new BookNotFoundException("No book found with the given author name!");
		}
		else {
			Integer bookid=tempbook.getBookId();
			repo.deleteById(bookid);
			return ResponseEntity.ok().build();
		}
	}
	public BookDTO getBookByAuthorName(String authorname) throws BookNotFoundException {
		Book book= repo.findByAuthorName(authorname);
		if(book==null) {
			throw new BookNotFoundException("No book found with the given author name!");
		}
		else {
			return BookUtils.convertToBookDto(book);
		}	
	}
}
