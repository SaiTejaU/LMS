package com.cg.lms.exception;

public class UserIdAlreadyExistException extends RuntimeException{	
	private static final long serialVersionUID = 1L;	

	public UserIdAlreadyExistException() {
        super();
    }

    public UserIdAlreadyExistException(String message) {
        super(message);
    }

    public UserIdAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

}