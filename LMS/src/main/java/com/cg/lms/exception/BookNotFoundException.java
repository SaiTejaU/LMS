package com.cg.lms.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception{
	public BookNotFoundException(String str){
		super(str);
	}
}
