package com.cg.lms.service;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception{
	public BookNotFoundException(String str){
		super(str);
	}
}
