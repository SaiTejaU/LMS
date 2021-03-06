package com.cg.lms.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.lms.entity.Book;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.model.BookDTO;
import com.cg.lms.repository.BookRepository;
import com.cg.lms.servicesimpl.BookServiceImpl;
import com.cg.lms.utils.BookUtils;

class BookServiceTest {
	@InjectMocks
	BookServiceImpl service;
	@Mock
	BookRepository repo;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetBookByName() throws BookNotFoundException {
		Book book=new Book();
		book.setBookId(101);
		book.setBookName("Java");
		book.setAuthorName("Moni");
		book.setBookCount(30);		
		book.setBookDescription("Year of Publication:2002");
		when(repo.findByName(anyString())).thenReturn(book);
		BookDTO bookdto=service.getBookByname("Fluid Mechanics");
		assertNotNull(bookdto);
		assertEquals("101",bookdto.getBookId());
	}
	@Test
	void testGetBookByName_BookNotFoundException()
	{
		when(repo.findByName( anyString())).thenReturn(null);
		assertThrows(BookNotFoundException.class,
				()-> {
					service.getBookByname("Fluid Mechanics");
				}
				);
	}
	@Test
	void testGetBookByAuthorName() throws BookNotFoundException
	{
		Book book=new Book();
		book.setBookId(102);
		book.setBookName("Programming");
		book.setAuthorName("Shanthiya");
		book.setBookCount(33);
		book.setBookDescription("Year of Publication:2006");
		when(repo.findByAuthorName(anyString())).thenReturn(book);
		BookDTO bookdto=service.getBookByAuthorName("SaiTeja");
		assertNotNull(bookdto);
		assertEquals("102",bookdto.getBookId());
		
	}
	@Test
	void testGetBookByAuthorName_BookNotFoundException()
	{
		when(repo.findByAuthorName( anyString())).thenReturn(null);
		assertThrows(BookNotFoundException.class,
				()-> {
					service.getBookByAuthorName("SaiTeja");
				}
				);
	}

@Test
void testaddBook() {
	BookDTO book = new BookDTO();
	book.setBookId(103);
	book.setBookName("Programming");
	book.setAuthorName("JK");
	book.setBookCount(33);
	book.setBookDescription("Year of Publication:2006");
	Book newbook1 = BookUtils.convertToBook(book);
	when(repo.saveAndFlush(newbook1)).thenReturn(BookUtils.convertToBook(book));
	assertThat(service.addBook(BookUtils.convertToBookDto(newbook1))).isEqualTo(book);

}
void testaddmultipleBooks()
{
	Book book = new Book();
	List<Book> list=new ArrayList<Book>();
	book.setBookId(103);
	book.setBookName("Programming");
	book.setAuthorName("JK");
	book.setBookCount(33);
	book.setBookDescription("Year of Publication:2006");
	list.add(book);	
	when(service.addMultipleBooks(BookUtils.convertToBookDtoList(list))).thenReturn(list);	
}
}