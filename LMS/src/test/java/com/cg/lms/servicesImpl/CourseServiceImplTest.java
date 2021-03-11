package com.cg.lms.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.lms.entity.Book;
import com.cg.lms.entity.Courses;
import com.cg.lms.entity.RequestedBook;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.utils.RequestedBookUtils;

@SuppressWarnings("unused")
class CourseServiceImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	/*@Test
	void testGetAllCourses() {
		
		List<Book> book1 = new ArrayList<Book>();
		//book1 = [("","R D")];
		Courses course1 = new Courses();
		course1.setId(2L);
		course1.setName("Physics");
		
		
		RequestedBook book2 = new RequestedBook();
		book2.setId(1L);
		book2.setName("Potter");
		book2.setAuthorName("Rowling");
		List<RequestedBookDTO> List = new ArrayList<>();
		List.add(RequestedBookUtils.convertToRequestedBookDto(book1));
		List.add(RequestedBookUtils.convertToRequestedBookDto(book2));
		when(newbookservice.getAllNewBooks()).thenReturn(List);
		
		//fail("Not yet implemented");
	}*/

	@Test
	void testCreateCourse() {
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteCourseById() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateCoursesById() {
		fail("Not yet implemented");
	}

}
