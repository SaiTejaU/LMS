package com.cg.lms.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Book;
import com.cg.lms.entity.Courses;
import com.cg.lms.entity.RequestedBook;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.repository.CourseRepository;
import com.cg.lms.utils.RequestedBookUtils;

@SpringBootTest
class CourseServiceImplTest {

	@Autowired
	private CourseRepository courserepo;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetAllCourses() {
		
		@SuppressWarnings("unused")
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
		//List.add(RequestedBookUtils.convertToRequestedBookDto(book1));
		List.add(RequestedBookUtils.convertToRequestedBookDto(book2));
		//when(newbookservice.getAllNewBooks()).thenReturn(List);
		
		//fail("Not yet implemented");
	}

	@Test
	void testCreateCourse() {
		//fail("Not yet implemented");
	}

	
	@Test
	void testDeleteCourseById() throws CourseNotFoundException {
		String coursebook1 ="Harry";
		String coursebook2 ="Potter";
		Courses course1 = new Courses();
		course1.setId(1L);
		course1.setName("Fun");
		course1.setRefBook(coursebook1);
		course1.setTextBook(coursebook2);
		
		Mockito.when(courserepo.save(course1)).thenReturn(course1);
        Mockito.when(courserepo.findById(1L).get()).thenReturn(course1);
        courserepo.deleteById(course1.getId());
        Mockito.when(courserepo.findById(1L).get()).thenReturn(course1);
		
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateCoursesById() {
		fail("Not yet implemented");
	}

}