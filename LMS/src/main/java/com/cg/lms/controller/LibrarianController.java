package com.cg.lms.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.servicesimpl.IssuedBooksServiceImpl;

@RestController
@RequestMapping("/librarian/")
public class LibrarianController {
	
	@Autowired
	private IssuedBooksServiceImpl service;
	
	@GetMapping("/getallissuedbooks")
	public List<IssuedBooksDTO> getAllIssuedBooks()
	{
		return service.getAllIssuedBooks();
	}
	
	@GetMapping("/calculatepenalties")
	public void calculatePenalties() throws ParseException
	{
		service.calulatePenalties();
	}
}
