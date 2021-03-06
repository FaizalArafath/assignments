package com.aspire.exception;

/**
 * Application exception will be catch if any unexpected error has been happened
 * while performing any operations. This exception doesn't handle anything for
 * now. It just call the super method.
 * 
 * @author faizal.arafath
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
