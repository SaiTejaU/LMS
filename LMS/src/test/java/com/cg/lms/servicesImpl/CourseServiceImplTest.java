package com.cg.lms.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.lms.entity.Book;
import com.cg.lms.entity.CourseBooks;
import com.cg.lms.entity.Courses;
import com.cg.lms.entity.RequestedBook;
import com.cg.lms.exception.CourseNotFoundException;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.repository.CourseRepository;
import com.cg.lms.servicesimpl.CourseServiceImpl;
import com.cg.lms.utils.RequestedBookUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
class CourseServiceImplTest {

	@Autowired
	private CourseRepository courserepo;
	
	@Autowired
	private CourseServiceImpl courseservice;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
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
		//List.add(RequestedBookUtils.convertToRequestedBookDto(book1));
		List.add(RequestedBookUtils.convertToRequestedBookDto(book2));
		//when(newbookservice.getAllNewBooks()).thenReturn(List);
		
		//fail("Not yet implemented");
	}

	@Test
	void testCreateCourse() {
		//fail("Not yet implemented");
	}

	@SuppressWarnings("deprecation")
	@Test
	void testDeleteCourseById() throws CourseNotFoundException {
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
		
		Mockito.when(courserepo.save(course1)).thenReturn(course1);
        Mockito.when(courserepo.findById(1L).get()).thenReturn(course1);
        courserepo.deleteById(course1.getId());
        Mockito.when(courserepo.findById(1L).get()).thenReturn(course1);
        Assert.assertEquals(course1, new Courses());
        Assert.assertEquals(courseservice.deleteCourseById(1), false);
		
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateCoursesById() {
		fail("Not yet implemented");
	}

}