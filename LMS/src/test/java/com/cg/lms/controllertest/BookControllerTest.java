package com.cg.lms.controllertest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.lms.*;

import com.cg.lms.controller.BookController;
import com.cg.lms.services.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)

public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BookService bookService;
	
	Book mockBook = new Book();
	
	@Test
	public void retrieveDetailsForBooks() throws Exception {
		Mockito.when(
				bookService.listAll()).thenReturn((List<Book>) mockBook);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{id:1,name:Spring,description:10Steps}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
	}
	}

