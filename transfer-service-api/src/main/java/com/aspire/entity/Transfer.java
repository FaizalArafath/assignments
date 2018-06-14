package com.aspire.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for the table transfer. This entity has many to one relation
 * with account table. One account can have many transactions. 
 * 
 * @author faizal.arafath
 *
 */

@Entity
@Table(name = "transfer")
public class Transfer extends AbstractEntity {

	@ManyToOne(optional = false)
	@JoinColumn(name = "from_account")
	private Account fromAccount;

	@ManyToOne(optional = false)
	@JoinColumn(name = "to_account")
	private Account toAccount;

	@Column(name = "amount")
	private long amount;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "error")
	private String error;

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
