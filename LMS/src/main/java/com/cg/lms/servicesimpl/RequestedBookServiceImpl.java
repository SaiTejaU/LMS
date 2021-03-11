package com.cg.lms.servicesimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.RequestedBook;
import com.cg.lms.model.RequestedBookDTO;
import com.cg.lms.repository.RequestedBookRepository;
import com.cg.lms.service.RequestedBookService;
import com.cg.lms.utils.RequestedBookUtils;

@Service
@Transactional
public class RequestedBookServiceImpl implements RequestedBookService {

	@Autowired
	private RequestedBookRepository newbookrepository;
	
	
	@Override
	public RequestedBook requestNewBook(RequestedBookDTO newbook) {
		RequestedBook newbook1 = RequestedBookUtils.convertToRequestedBook(newbook);
		return newbookrepository.saveAndFlush(newbook1);
		 
	}

	@Override
	public List<RequestedBookDTO> getAllRequestedBooks() {
        
		List<RequestedBook> newbook = newbookrepository.findAll();
		return RequestedBookUtils.convertToBookDtoList(newbook);
	}
	     
	
            
}
