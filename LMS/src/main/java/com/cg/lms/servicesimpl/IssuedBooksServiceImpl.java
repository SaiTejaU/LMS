package com.cg.lms.servicesimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.IssuedBooks;
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
	public List<IssuedBooksDTO> calulatePenalties() throws ParseException {
		List<IssuedBooksDTO> defaulters=new ArrayList<IssuedBooksDTO>();
		for(IssuedBooksDTO book:IssuedBookUtils.convertToIssuedBookDtoList(issuedrepo.findAll()))
		{
			Date issueDate=dateFormat.parse(book.getDateIssued());
			Date today=new Date(System.currentTimeMillis());
			if(today.getTime()-issueDate.getTime()>limitDays)
			{
				book.setPenalty(book.getPenalty()+((today.getTime()-issueDate.getTime())/1000/60/60/24)*finePerDay);
				issuedrepo.save(IssuedBookUtils.convertToIssuedBooks(book));
				defaulters.add(book);
			}
		}
		return defaulters;
	}
	public List<IssuedBooksDTO> issuedBooks(){
		List<IssuedBooks> books= issuedrepo.findAll();
		return IssuedBookUtils.convertToIssuedBookDtoList(books);
	}
}
