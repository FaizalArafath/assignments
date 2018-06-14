package com.aspire.dto;

import java.util.Date;

/**
 * TransactionDto is used to transfer data from controller to service. Object
 * holds required attributes to transfer amount from one account to another.
 * 
 * @author faizal.arafath
 *
 */
public class TransactionDto {

	private String fromAccount;
	private String toAccount;
	private long amount;
	private Date date;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
