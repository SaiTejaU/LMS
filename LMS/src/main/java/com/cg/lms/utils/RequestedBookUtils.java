package com.cg.lms.utils;

import java.util.ArrayList;
import java.util.List;


import com.cg.lms.entity.RequestedBook;

import com.cg.lms.model.RequestedBookDTO;

public class RequestedBookUtils {

	private RequestedBookUtils()
	{	
	}

	public static List<RequestedBookDTO> convertToBookDtoList(List<RequestedBook> list){
		List<RequestedBookDTO> newbookdtolist = new ArrayList<>();
		for(RequestedBook newbook : list) 
			newbookdtolist.add(convertToRequestedBookDto(newbook));
		return newbookdtolist;
	}
	
	public static RequestedBook convertToRequestedBook(RequestedBookDTO newbookdto) {
		RequestedBook newbook = new RequestedBook();
		newbook.setId(newbookdto.getId());
		newbook.setName(newbookdto.getName());
		newbook.setAuthorName(newbookdto.getAuthorName());
		return newbook;
	}
	public static RequestedBookDTO convertToRequestedBookDto(RequestedBook newbook) {
		RequestedBookDTO newbookdto = new RequestedBookDTO();
		newbookdto.setName(newbook.getName());
		newbookdto.setId(newbook.getId());
		newbookdto.setAuthorName(newbook.getAuthorName());
		return newbookdto;
	}
	
}

