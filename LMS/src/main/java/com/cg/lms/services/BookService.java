package com.cg.lms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.Book;
import com.cg.lms.execption.BookNotFoundExecption;
import com.cg.lms.repository.BookRepository;


@Service
@Transactional
public class BookService {
	@Autowired
    BookRepository repo;
     
    public List<Book> listAll() {
       
        return repo.findAll();
    }
	public List<Book> getBookByBookName(String name) throws BookNotFoundExecption{
		Optional<List<Book>> optional=Optional.ofNullable(repo.findByBookName(name));
		if(optional.isPresent()) {
		return repo.findByBookName(name);
		}
		else {
			throw new BookNotFoundExecption("Book not found for the given name");
		}
	}
	public List<Book> getBookByBookId(Integer id) throws BookNotFoundExecption{
		Optional<List<Book>> optional=Optional.ofNullable(repo.findByBookId(id));
		if(optional.isPresent()) {
		return repo.findByBookId(id);
		}
		else
		{
			throw new BookNotFoundExecption("Book not found for the given id");
		}
	}
	public List<Book> getBookByAuthorName(String authorname) throws BookNotFoundExecption {
		Optional<List<Book>> optional=Optional.ofNullable(repo.findByAuthorName(authorname));
		if(optional.isPresent()) {
		return repo.findByAuthorName(authorname);
		}
		else
		{
			throw new BookNotFoundExecption("Book not found for the given authorname");
		}
		
	}
     
}

