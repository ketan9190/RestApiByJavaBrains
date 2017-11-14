package com.rest.tutorials.messanserInRest.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285865445334334209L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
