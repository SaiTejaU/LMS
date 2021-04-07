package com.cg.lms.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.servicesimpl.IssuedBooksServiceImpl;

@RestController
@RequestMapping("/librarian/")
@CrossOrigin(origins="http://localhost:3000")
public class LibrarianController {
	
	@Autowired
	private IssuedBooksServiceImpl service;
	
	@GetMapping("/calculatepenalties")
	public List<IssuedBooksDTO> calculatePenalties() throws ParseException
	{
		return service.calulatePenalties();
	}
	@GetMapping("/getissuedbooks")
	public List<IssuedBooksDTO> getBooks(){
		return service.issuedBooks();
	}
}
