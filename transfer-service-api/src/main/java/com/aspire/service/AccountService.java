package com.aspire.service;

import com.aspire.dto.AccountCreationRequest;
import com.aspire.dto.AccountCreationResponse;
import com.aspire.dto.AccountDto;
import com.aspire.dto.BaseResponse;

/**
 * This interface exposes all operation that can be done in Account activity.
 * 
 * @author faizal.arafath
 *
 */
public interface AccountService {

	public AccountCreationResponse create(AccountCreationRequest request);

	public BaseResponse activate(String accountId);

	public AccountDto fetch(String accountId);

	public BaseResponse update(AccountDto request);

	public BaseResponse delete(String accountId);

	public void login();

	public void changePassword();

	public long getBalance(String accountId);

}
