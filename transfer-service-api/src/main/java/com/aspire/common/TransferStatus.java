/**
 * 
 */
package com.aspire.common;

/**
 * @author faizal.arafath
 *
 */
public enum TransferStatus {
	COMPLETED(0), ERROR(1);

	private final int value;

	private TransferStatus(int value) {
		this.value = value;
	}

	public final int getValue() {
		return value;
	}
}
