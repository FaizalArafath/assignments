/**
 * 
 */
package com.aspire.exception;

/**
 * Transfer exception will be catch specifically when doing amount transfer.
 * This class is created and kept away from other exception is because transfer
 * operation is the heart of the project. Transfer operation needs special
 * handling. For now this exception handle anything. it just call the super
 * method.
 * 
 * @author faizal.arafath
 *
 */
public class TransferException extends Exception {

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
