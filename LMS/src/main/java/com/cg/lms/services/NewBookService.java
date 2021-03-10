package com.cg.lms.services;


import com.cg.lms.model.NewBook;

public interface NewBookService {

     NewBook createNewBook(NewBook newbook);
	Iterable<NewBook> getAllNewBooks();
}
