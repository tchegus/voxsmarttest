package com.voxsmart.test.exception;

public class NumberUnknownException extends RuntimeException {
	
	private static final long serialVersionUID = 6077165414867087292L;

	/**
	 *  This exception is thrown when the national phone Number provided is unknown
	 * Add a custom message when throwing the exception as
	 * throw new NumberUnknownException(" Custom Unchecked Exception ");
	 */
	public NumberUnknownException(String message) {
		super(message);
	}
}
