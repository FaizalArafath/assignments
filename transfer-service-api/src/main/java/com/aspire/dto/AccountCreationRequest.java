package com.aspire.dto;

import com.aspire.common.AccountType;

/**
 * This class is a data transfer object which is used in when creating account.
 * Account controller expect the parameter of this object type. Which has
 * attributes to create account.
 * 
 * @author faizal.arafath
 *
 */
public class AccountCreationRequest {

	private String name;
	// In euro cents
	private long amount;
	private AccountType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}
}
