package com.aspire.dto;

import java.util.List;

import javax.transaction.Transaction;

/**
 * This class object is used across the place where user fetch or update account
 * information. Fetch request will fetch account information from db and
 * construct AccountDto to return response. Similarly update request will expect
 * the same accountDto object, update service will get details from the dto and
 * update to db.
 * 
 * @author faizal.arafath
 *
 */
public class AccountDto extends BaseResponse {
	private String accountId;
	private String name;
	private long balance;
	private List<Transaction> transactions;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
