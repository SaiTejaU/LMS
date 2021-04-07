package com.cg.lms.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.cg.lms.entity.CourseBooks;
import com.cg.lms.entity.Courses;
import com.cg.lms.entity.RequestedBook;
import com.cg.lms.model.CoursesDTO;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.repository.RequestedBookRepository;
import com.cg.lms.servicesimpl.CourseServiceImpl;
import com.cg.lms.servicesimpl.RequestedBookServiceImpl;
import com.cg.lms.utils.CourseUtils;
import com.cg.lms.utils.RequestedBookUtils;


class CourseControllerTest {

	@InjectMocks
	CourseController controller;
	
	@Mock
	RequestedBookRepository newbookrepository;
	
	@Mock
	RequestedBookServiceImpl newbookservice;
	
	@Mock
	CourseServiceImpl courseservice;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	
	@Test
	void testGetAllCourses() {
		CourseBooks coursebook1 = new CourseBooks();
		coursebook1.setId(1);
		coursebook1.setName("Harry");
		CourseBooks coursebook2 = new CourseBooks();
		coursebook2.setId(2);
		coursebook2.setName("Potter");
		List<CourseBooks> list = new ArrayList<>();
		Courses course1 = new Courses();
		course1.setId(1L);
		course1.setName("Fun");
		course1.setCoursebook(list);
		Courses course2 = new Courses();
		course2.setId(2L);
		course2.setName("Enjoy");
		course2.setCoursebook(list);
		List<CoursesDTO> list1 = new ArrayList<>();
		list1.add(CourseUtils.convertToCoursesDto(course1));
		list1.add(CourseUtils.convertToCoursesDto(course2));
		when(courseservice.getAllCourses()).thenReturn(list1);
		assertThat(courseservice.getAllCourses()).isEqualTo(list1);
		
		//fail("Not yet implemented");
	}

	@Test
	void testCreateCourse() {
		CourseBooks coursebook1 = new CourseBooks();
		coursebook1.setId(1);
		coursebook1.setName("Harry");
		CourseBooks coursebook2 = new CourseBooks();
		coursebook2.setId(2);
		coursebook2.setName("Potter");
		List<CourseBooks> list = new ArrayList<>();
		Courses course1 = new Courses();
		course1.setId(1L);
		course1.setName("Fun");
		course1.setCoursebook(list);
		CoursesDTO course2 = CourseUtils.convertToCoursesDto(course1);
		when(courseservice.createCourse(course2)).thenReturn(course1);
		assertThat(courseservice.createCourse(course2)).isEqualTo(course1);
		
		
		//fail("Not yet implemented");
	}

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
		RequestedBook newbook;
		newbook = new RequestedBook();
		newbook.setAuthorName("JK ROWLING");
		newbook.setId(1L);
		newbook.setName("Harry Potter");
		RequestedBookDTO newbook1 = RequestedBookUtils.convertToRequestedBookDto(newbook);
		when(newbookservice.requestNewBook(newbook1)).thenReturn(newbook);
		assertThat(newbookservice.requestNewBook(newbook1)).isEqualTo(newbook);
	}

	
	@Test
	void testDeleteCourseById() {
		//fail("Not yet implemented");
	}

}