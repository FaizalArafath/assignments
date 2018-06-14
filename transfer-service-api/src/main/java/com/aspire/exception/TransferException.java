/**
 * 
 */
package com.aspire.exception;

/**
 * @author faizal.arafath
 *
 */
public class TransferException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferException(String message) {
		super(message);
	}
	
	public TransferException(Throwable cause) {
		super(cause);
	}
	
	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}

}
