package com.cg.lms.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.lms.entity.IssuedBooks;
import com.cg.lms.model.IssuedBooksDTO;

public class IssuedBookUtils {
	private IssuedBookUtils(){
	}
	public static List<IssuedBooksDTO> convertToIssuedBookDtoList(List<IssuedBooks> list){
		List<IssuedBooksDTO> bookdtolist = new ArrayList<>();
		for(IssuedBooks book : list) 
			bookdtolist.add(convertToIssuedBooksDTO(book));
		return bookdtolist;
	}
	public static IssuedBooks convertToIssuedBooks(IssuedBooksDTO issuedbookdto) {
		IssuedBooks book = new IssuedBooks();
		book.setBookId(issuedbookdto.getBookId());
		book.setUserId(issuedbookdto.getUserId());
		book.setDateIssued(issuedbookdto.getDateIssued());
		return book;
	}
	public static IssuedBooksDTO convertToIssuedBooksDTO(IssuedBooks issuedbook) {
		IssuedBooksDTO bookdto = new IssuedBooksDTO();
		bookdto.setBookId(issuedbook.getBookId());
		bookdto.setUserId(issuedbook.getUserId());
		bookdto.setDateIssued(issuedbook.getDateIssued());
		return bookdto;
	}
		
}
