package com.cg.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.Book;
import com.cg.lms.repository.BookRepository;


@Service
public class BookService {
	@Autowired
    BookRepository repo;
     
    public List<Book> listAll() {
       
        return repo.findAll();
    }
	public List<Book> getBookByBookName(String name) {
		return repo.findByBookName(name);
	}
	public List<Book> getBookByBookId(Integer id) {
		return repo.findByBookId(id);
	}
	public List<Book> getBookByAuthorName(String authorname) {
		return repo.findByAuthorName(authorname);
		
	}
     
}

