package com.cg.lms.servicesimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.model.IssuedBooksDTO;
import com.cg.lms.repository.IssuedBooksRepository;
import com.cg.lms.service.IssuedBooksService;
import com.cg.lms.utils.IssuedBookUtils;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService{

	@Autowired
	IssuedBooksRepository issuedrepo;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
	int limitDays=14;
	Double finePerDay=5.0;
	
	@Override
	public List<IssuedBooksDTO> getAllIssuedBooks() {
		return IssuedBookUtils.convertToIssuedBookDtoList(issuedrepo.findAll());
	}

	@Override
	public void calulatePenalties() throws ParseException {
		for(IssuedBooksDTO book:getAllIssuedBooks())
		{
			Date issueDate=dateFormat.parse(book.getDateIssued());
			Date today=new Date(System.currentTimeMillis());
			if(today.getTime()-issueDate.getTime()>limitDays)
			{
				book.setPenalty(book.getPenalty()+(today.getTime()-issueDate.getTime())*finePerDay);
				issuedrepo.save(IssuedBookUtils.convertToIssuedBooks(book));
			}
		}
	}
}
