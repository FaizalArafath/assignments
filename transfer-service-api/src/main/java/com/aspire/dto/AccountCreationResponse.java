package com.aspire.dto;

/**
 * This class is a data transfer object which is used in when creating account.
 * Account controller return the parameter of this object type. Which has
 * attributes like activation line and accountId.
 * 
 * For now added activation link is just added as project skeleton. actual
 * implementation is not done yet.
 * 
 * @author faizal.arafath
 *
 */
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
