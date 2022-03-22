package com.kreasi.app.exception;

public class ConflictException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConflictException(String msg, Throwable e) {
		super(msg,e);
	}
	
	public ConflictException(String msg) {
		super(msg);
	}

}
