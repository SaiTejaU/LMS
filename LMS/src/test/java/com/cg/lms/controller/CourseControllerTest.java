
package com.cg.lms.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.lms.entity.RequestedBook;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.repository.RequestedBookRepository;
import com.cg.lms.servicesimpl.RequestedBookServiceImpl;
import com.cg.lms.utils.RequestedBookUtils;

class CourseControllerTest {

	@InjectMocks
	CourseController controller;
	
	@Mock
	RequestedBookRepository newbookrepository;
	
	@Mock
	RequestedBookServiceImpl newbookservice;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	
	@Test
	void testGetAllCourses() {
		
		//fail("Not yet implemented");
	}
/*
	@Test
	void testCreateCourse() {
		fail("Not yet implemented");
	}
*/
	@Test
	void testGetAllRequestedBooks() {
		RequestedBook book1 = new RequestedBook();
		book1.setId(2L);
		book1.setName("Harry");
		book1.setAuthorName("JK");
		
		RequestedBook book2 = new RequestedBook();
		book2.setId(1L);
		book2.setName("Potter");
		book2.setAuthorName("Rowling");
		List<RequestedBookDTO> List = new ArrayList<>();
		List.add(RequestedBookUtils.convertToRequestedBookDto(book1));
		List.add(RequestedBookUtils.convertToRequestedBookDto(book2));
		when(newbookservice.getAllRequestedBooks()).thenReturn(List);
		assertThat(newbookservice.getAllRequestedBooks()).isEqualTo(List);
	}
	
	@Test
	void testRequestNewBook() {
		RequestedBookDTO newbook;
		newbook = new RequestedBookDTO();
		newbook.setAuthorName("JK ROWLING");
		newbook.setId(1L);
		newbook.setName("Harry Potter");
		RequestedBook newbook1 = RequestedBookUtils.convertToRequestedBook(newbook);
		Mockito.when(newbookrepository.saveAndFlush(newbook1)).thenReturn(newbook1);
		RequestedBook outbook = newbookservice.requestNewBook(newbook);
		assertNotNull(outbook);
		assertEquals(newbook,outbook);
	}

	
	/*@Test
	void testDeleteCourseById() {
		fail("Not yet implemented");
	}*/

}
