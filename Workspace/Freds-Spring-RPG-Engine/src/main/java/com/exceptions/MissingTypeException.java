package com.exceptions;

public class MissingTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingTypeException(String errorMessage) {
        super(errorMessage);
    }
}
