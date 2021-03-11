package com.cg.lms.service;


import java.util.List;

import com.cg.lms.entity.RequestedBook;
import com.cg.lms.model.RequestedBookDTO;

public interface RequestedBookService {

     RequestedBook requestNewBook(RequestedBookDTO newbookdto);
	 List<RequestedBookDTO> getAllRequestedBooks();
	
}
