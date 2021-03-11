package com.cg.lms.exception;

@SuppressWarnings("serial")
public class BookNotIssuedError extends Exception{
	public BookNotIssuedError(String msg)
	{
		super(msg);
	}
}
