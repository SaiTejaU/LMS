package com.cg.lms.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.lms.entity.Book;
import com.cg.lms.model.BookDTO;

public class BookUtils {
	private BookUtils()
	{	
	}

	public static List<BookDTO> convertToBookDtoList(List<Book> list){
		List<BookDTO> bookdtolist = new ArrayList<>();
		for(Book book : list) 
			bookdtolist.add(convertToBookDto(book));
		return bookdtolist;
	}
	
	public static Book convertToBook(BookDTO bookdto) {
		Book book = new Book();
		book.setBookId(bookdto.getBookId());
		book.setBookName(bookdto.getBookName());
		book.setAuthorName(bookdto.getAuthorName());
		book.setBookDescription(bookdto.getBookDescription());
		book.setBookCount(bookdto.getBookCount());
		return book;
	}
	public static BookDTO convertToBookDto(Book book) {
		BookDTO bookdto = new BookDTO();
		bookdto.setBookId(book.getBookId());
		bookdto.setBookName(book.getBookName());
		bookdto.setAuthorName(book.getAuthorName());
		bookdto.setBookDescription(book.getBookDescription());
		bookdto.setBookCount(book.getBookCount());
		return bookdto;
	}
	public static List<Book> convertToBookList(List<BookDTO> dtolist)
	{
		List<Book> list= new ArrayList<>();
		for(BookDTO book:dtolist)
			list.add(convertToBook(book));
		return list;
	}
		
}