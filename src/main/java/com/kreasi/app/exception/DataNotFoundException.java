package com.kreasi.app.exception;

public class DataNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String msg, Throwable e) {
		super(msg,e);
	}
	
	public DataNotFoundException(String msg) {
		super(msg);
	}

}
