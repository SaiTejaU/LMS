package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		Optional<Book> optional= repo.findByName(name);
		if(optional.isPresent()) {
			Book book= optional.get();
			return BookUtils.convertToBookDto(book);
		}
		else {
			throw new BookNotFoundException("No book found with the given name!");
			
		}	
	}
	public String deleteBookByName(String name) //throws BookNotFoundException
	{
		repo.deleteByName(name);
		return "Book deleted!";
	}
	public List<Book> getBookByAuthorName(String authorname) throws BookNotFoundException {
		Optional<List<Book>> optional=Optional.ofNullable(repo.findByAuthorName(authorname));
		if(optional.isPresent()) {
		return repo.findByAuthorName(authorname);
		}
		else
		{
			throw new BookNotFoundException("Book not found for the given authorname");
		}
		
	}
}
