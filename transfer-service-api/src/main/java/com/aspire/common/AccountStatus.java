package com.aspire.common;

/**
 * Enum to holds status of account. This will also gives integer value of the
 * account state.
 * 
 * @author faizal.arafath
 *
 */
public enum AccountStatus {
	SUSPENDED(0), ACTIVE(1), HOLD(2), PENDING_VERIFICATION(3), DELETED(4);

	private final int value;

	private AccountStatus(int value) {
		this.value = value;
	}

	public final int getValue() {
		return value;
	}

}
