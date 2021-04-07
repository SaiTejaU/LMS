package com.cg.lms.service;

import java.text.ParseException;
import java.util.List;

import com.cg.lms.model.IssuedBooksDTO;

public interface IssuedBooksService {
	public List<IssuedBooksDTO> calulatePenalties() throws ParseException;
}
