package com.cg.lms.servicesimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Book;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.exception.BookNotIssuedError;
import com.cg.lms.exception.NoBooksLeftException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.repository.BookRepository;
import com.cg.lms.repository.IssuedBooksRepository;
import com.cg.lms.service.BookService;
import com.cg.lms.utils.BookUtils;
import com.cg.lms.utils.IssuedBookUtils;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository repo;
	@Autowired
	IssuedBooksRepository issuedrepo;
	
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
	public BookDTO getBookByAuthorName(String authorname) throws BookNotFoundException {
		Book book= repo.findByAuthorName(authorname);
		if(book==null) {
			throw new BookNotFoundException("No book found with the given author name!");
		}
		else {
			return BookUtils.convertToBookDto(book);
		}	
	}
	public IssuedBooksDTO getBookIssued(String bookname) throws BookNotFoundException, NoBooksLeftException 
	{
		Book book=repo.findByName(bookname);
		if(book==null)
			throw new BookNotFoundException("Book not found with that name!");
		else if(book.getBookCount()==0)
			throw new NoBooksLeftException("All are issued!");
		else {
			IssuedBooksDTO issuedbookdto=new IssuedBooksDTO();
			issuedbookdto.setBookId(book.getBookId());
			issuedbookdto.setUserId("Dummy");
			issuedbookdto.setDateIssued(new Date(System.currentTimeMillis()).toString());
			issuedbookdto.setPenalty(0.0);
			issuedrepo.save(IssuedBookUtils.convertToIssuedBooks(issuedbookdto));
			book.setBookCount(book.getBookCount()-1);
			this.repo.save(book);
			return issuedbookdto;
		}
	}
	@Override
	public String returnBook(String bookname) throws BookNotIssuedError {
		IssuedBooksDTO bookdto=IssuedBookUtils.convertToIssuedBooksDTO(issuedrepo.findById(bookname).get());
		if(!issuedrepo.existsById(bookname))
		{
			throw new BookNotIssuedError("You didn't got this book issued yet!");
		}
		else if(bookdto.getPenalty()>0.0)
		{
			issuedrepo.delete(IssuedBookUtils.convertToIssuedBooks(bookdto));
			return "Book successfully returned!";
		}
		else
		{
			Double penalty=bookdto.getPenalty();
			issuedrepo.delete(IssuedBookUtils.convertToIssuedBooks(bookdto));
			return "Book returned.\nYou have a penalty of "+penalty+". Please pay it by visiting the office!";
		}
	}
	
}
