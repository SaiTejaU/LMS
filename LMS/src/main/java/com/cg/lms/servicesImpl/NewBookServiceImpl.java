package com.cg.lms.servicesImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.model.NewBook;
import com.cg.lms.repo.NewBookRepository;
import com.cg.lms.services.NewBookService;

@Service
@Transactional
public class NewBookServiceImpl implements NewBookService {

	@Autowired
	private NewBookRepository newbookrepository;
	
	@Override
	public NewBook createNewBook(NewBook newbook) {
		
		return newbookrepository.save(newbook);
	}

	@Override
	public Iterable<NewBook> getAllNewBooks() {
		// TODO Auto-generated method stub
		return newbookrepository.findAll();
	}
	     
	
            
}
