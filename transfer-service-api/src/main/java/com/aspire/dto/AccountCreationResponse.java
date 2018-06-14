package com.aspire.dto;

public class AccountCreationResponse extends BaseResponse {
	
	private String accountId;
	private String activationLink;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getActivationLink() {
		return activationLink;
	}

	public void setActivationLink(String activationLink) {
		this.activationLink = activationLink;
	}
}
