/**
 * 
 */
package com.aspire.common;

/**
 * @author faizal.arafath
 *
 */
public enum AccountType {
	DEFAULT(0), PREMIUM(1);

	private final int value;

	private AccountType(int value) {
		this.value = value;
	}

	public final int getValue() {
		return value;
	}
}
