package com.cg.lms.exception;

@SuppressWarnings("serial")
public class NoBooksLeftException extends Exception{
	public NoBooksLeftException(String str){
		super(str);
	}
}
