/**
 * 
 */
package com.aspire.common;

/**
 * Enum to holds account type. This will also gives integer value of the
 * account type.
 * 
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
