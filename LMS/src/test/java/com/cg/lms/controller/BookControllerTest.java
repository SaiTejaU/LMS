package com.cg.lms.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.cg.lms.entity.Book;

import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.model.BookDTO;

import com.cg.lms.service.BookService;
import com.cg.lms.utils.BookUtils;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class BookControllerTest {
	@InjectMocks
	BookController controller;
	
	@Mock
	BookService service;
	
	BookDTO bookdto;
	final String BOOK_NAME="Java";
	final String AUTHOR_NAME="Moni";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		bookdto=new BookDTO();
		bookdto.setBookId(101);
		bookdto.setAuthorName(AUTHOR_NAME);
		bookdto.setBookCount(20);
		bookdto.setBookDescription("Year of Publication:2002");
		bookdto.setBookName(BOOK_NAME);
	}

	@Test
	void testGetBookByName() throws BookNotFoundException {
		when(service.getBookByname(anyString())).thenReturn(bookdto);
		BookDTO outbook=service.getBookByname(BOOK_NAME);
		assertNotNull(BOOK_NAME,outbook.getBookName());
		assertEquals(bookdto.getAuthorName(),outbook.getAuthorName());
		assertEquals(bookdto.getBookCount(),outbook.getBookCount());
		assertEquals(bookdto.getBookDescription(),outbook.getBookDescription());
		assertEquals(bookdto.getBookId(),outbook.getBookId());
				
	}
	
	@Test
	void testGetBookByAuthorName() throws  BookNotFoundException {
		when(service.getBookByAuthorName(anyString())).thenReturn(bookdto);
		BookDTO outbook=service.getBookByAuthorName(AUTHOR_NAME);
		assertNotNull(AUTHOR_NAME,outbook.getAuthorName());
		assertEquals(bookdto.getBookName(),outbook.getBookName());
		assertEquals(bookdto.getBookCount(),outbook.getBookCount());
		assertEquals(bookdto.getBookDescription(),outbook.getBookDescription());
		assertEquals(bookdto.getBookId(),outbook.getBookId());
				
	}
	
	@Test
	void testGetAllBook()
	{
		Book book1=new Book();
		book1.setBookId(10);
		book1.setBookName("Structural Analysis");
		book1.setAuthorName("Teraja");
		book1.setBookCount(20);
		book1.setBookDescription("Year of Publication:2000");
		
		Book book2=new Book();
		book1.setBookId(120);
		book1.setBookName("Structure of Materials");
		book1.setAuthorName("Agarwal");
		book1.setBookCount(23);
		book1.setBookDescription("Year of Publication:2001");

		
		List<BookDTO> List=new ArrayList<>();
		List.add(BookUtils.convertToBookDto(book1));
		List.add(BookUtils.convertToBookDto(book2));
		when(service.getBooks()).thenReturn(List);
		assertThat(service.getBooks()).isEqualTo(List);
	}
	


	@Test
	void testaddnewbook() {
		Book book1=new Book();
		book1.setBookId(100);
		book1.setBookName("Structural Analysis");
		book1.setAuthorName("Teraja");
		book1.setBookCount(20);
		book1.setBookDescription("Year of Publication:2000");
		
		Book book2=new Book();
		book2.setBookId(120);
		book2.setBookName("Structure of Materials");
		book2.setAuthorName("Agarwal");
		book2.setBookCount(23);
		book2.setBookDescription("Year of Publication:2001");
		
	
		OngoingStubbing<List<BookDTO>> thenReturn = when(service.getBooks()).thenReturn((List<BookDTO>) book1);
		assertThat(service.getBooks()).isEqualTo(book2);
	}

	

}