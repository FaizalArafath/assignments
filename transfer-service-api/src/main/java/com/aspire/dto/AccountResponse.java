package com.aspire.dto;

/**
 * AccountResponse is used to return the response when user requesting for
 * account details.
 * 
 * @author faizal.arafath
 *
 */
public class AccountResponse extends BaseResponse {
	private AccountDto accountInfo;

	public AccountDto getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountDto accountInfo) {
		this.accountInfo = accountInfo;
	}
}
