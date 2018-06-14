/**
 * 
 */
package com.aspire.common;

/**
 * Enum to holds status of Transfer. Each transaction will be having its own
 * status. This will also gives integer value of the transfer.
 * 
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
