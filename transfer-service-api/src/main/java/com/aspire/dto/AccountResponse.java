package com.aspire.dto;

public class AccountResponse extends BaseResponse {
	private AccountDto accountInfo;

	public AccountDto getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountDto accountInfo) {
		this.accountInfo = accountInfo;
	}
}
