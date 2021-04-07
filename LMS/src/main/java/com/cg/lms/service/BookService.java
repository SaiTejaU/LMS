package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Book;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.exception.BookNotIssuedError;
import com.cg.lms.exception.NoBooksLeftException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.model.IssuedBooksDTO;

public interface BookService {
	public List<BookDTO> getBooks();
	public Book addBook(BookDTO bookdto);
	public BookDTO getBookById(Long bookId) throws BookNotFoundException;
	public BookDTO getBookByname(String name) throws BookNotFoundException ;
	public BookDTO getBookByAuthorName(String authorname) throws BookNotFoundException;
	public IssuedBooksDTO getBookIssued(Long id) throws BookNotFoundException, NoBooksLeftException ;
	public String returnBook(String bookname) throws BookNotIssuedError;
	public List<Book> addMultipleBooks(List<BookDTO> bookdto);
	public Book updateBook(BookDTO bookdto) throws BookNotFoundException;
}