package com.voxsmart.test.exception;

public class PhoneNumberValidationException extends RuntimeException {

	private static final long serialVersionUID = -1307450093611274922L;

	/**
	 *  This exception is thrown when phone Number format is not a valid
	 * Add a custom message when throwing the exception as
	 * throw new NumberValidationException(" Custom Unchecked Exception ");
	 */
	public PhoneNumberValidationException(String message) {
		super(message);
	}
}
