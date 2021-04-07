package com.cg.lms.servicesimpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
	 public BookDTO getBookById(Long bookId) throws BookNotFoundException{
	    	Optional<Book> opt= repo.findById(bookId);		
			if(opt.isPresent()) {
				Book book= opt.get();
				return BookUtils.convertToBookDto(book);
			}
			else {
				throw new BookNotFoundException("Book not found for the given book Id");			
			}
	    }
	public List<BookDTO> getBooks() {
		List<Book> booklist= repo.findAll();
		return BookUtils.convertToBookDtoList(booklist);
	}
	public Book addBook(BookDTO bookdto) {
		return repo.save(BookUtils.convertToBook(bookdto));
	}
	
	public List<Book> addMultipleBooks(List<BookDTO> bookdto) {
		
		List<Book> book=BookUtils.convertToBookList(bookdto);
		for(Book b:book)
		{
			repo.save(b);
		}
		return book;
		//return repo.save(BookUtils.convertToBook((BookDTO) bookdto));
		
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
	public IssuedBooksDTO getBookIssued(Long id) throws BookNotFoundException, NoBooksLeftException 
	{
		Optional<Book> opt=repo.findById(id);
		if(opt.isPresent()) {
			Book book=opt.get();
			if(book==null)
				throw new BookNotFoundException("Book not found with that name!");
			else if(book.getBookCount()==0)
				throw new NoBooksLeftException("All are issued!");
			else if(!issuedrepo.existsById(id)){
				IssuedBooksDTO issuedbookdto=new IssuedBooksDTO();
				issuedbookdto.setBookId(book.getBookId());
				issuedbookdto.setBookName(book.getBookName());
				issuedbookdto.setUserId("Dummy");
				issuedbookdto.setDateIssued(new Date(System.currentTimeMillis()).toString());
				issuedbookdto.setPenalty(0.0);
				issuedrepo.save(IssuedBookUtils.convertToIssuedBooks(issuedbookdto));
				book.setBookCount(book.getBookCount()-1);
				this.repo.save(book);
				return issuedbookdto;
			}
		}
		return null;
	}
	public Book updateBook(BookDTO bookdto) throws BookNotFoundException {
    	Optional<Book> opt= repo.findById(bookdto.getBookId());
    	Book book=new Book();
    	if(opt.isPresent()) {  
    		book.setBookId(bookdto.getBookId());
    		book.setBookName(bookdto.getBookName());
    		book.setAuthorName(bookdto.getAuthorName());
    		book.setBookCount(bookdto.getBookCount());
    		book.setBookDescription(bookdto.getBookDescription());
        }          
    else{
    	throw new BookNotFoundException("BookId "+bookdto.getBookId()+" not found");
    }       
    repo.save(book);
    return book;        
}
	@Override
	public String returnBook(String bookname) throws BookNotIssuedError {
		Book book=repo.findByName(bookname);
		Long id=book.getBookId();
		IssuedBooksDTO bookdto=IssuedBookUtils.convertToIssuedBooksDTO(issuedrepo.findById(id).get());
		if(!issuedrepo.existsById(id))
		{
			throw new BookNotIssuedError("You didn't got this book issued yet!");
		}
		else if(bookdto.getPenalty()>0.0)
		{
			Double penalty=bookdto.getPenalty();
			issuedrepo.delete(IssuedBookUtils.convertToIssuedBooks(bookdto));
			book.setBookCount(book.getBookCount()+1);
			repo.save(book);
			return "Book returned.\nYou have a penalty of "+penalty+". Please pay it by visiting the office!";
		}
		else
		{
			issuedrepo.delete(IssuedBookUtils.convertToIssuedBooks(bookdto));
			book.setBookCount(book.getBookCount()+1);
			repo.save(book);
			return "Book successfully returned!";
			
		}
	}
	
}