package com.cg.lms.service;


import com.cg.lms.entity.NewBook;

public interface NewBookService {

     NewBook createNewBook(NewBook newbook);
	Iterable<NewBook> getAllNewBooks();
}
