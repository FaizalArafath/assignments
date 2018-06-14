package com.aspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.common.AccountStatus;
import com.aspire.dto.AccountCreationRequest;
import com.aspire.dto.AccountCreationResponse;
import com.aspire.dto.AccountDto;
import com.aspire.dto.BaseResponse;
import com.aspire.entity.Account;
import com.aspire.repository.AccountRepository;
import com.aspire.service.AccountService;

/**
 * This class has the actual implementation and business logic for all
 * operations that are exposed.
 * 
 * @author faizal.arafath
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Method to create account. It requires object type AccountCreationRequest.
	 * It will return the response as AccountCreationReponse. To create new
	 * account basic validation have been done to check the combination of
	 * account name and type has already been there in the system.
	 */
	@Override
	public AccountCreationResponse create(AccountCreationRequest request) {
		// validation to check the account name is already exist in the system
		List<Account> accounts = accountRepository.fetchAccountNameAndType(
				request.getName(), request.getType());
		AccountCreationResponse response = new AccountCreationResponse();
		if (accounts == null) {
			Account account = new Account();
			account.setBalance(request.getAmount());
			account.setName(request.getName());
			account.setType(request.getType().getValue());
			account.setStatus(AccountStatus.ACTIVE.getValue());
			accountRepository.save(account);
			response.setAccountId(account.getId());
		} else {
			response.setMessage("Account Name and Type already exist!!");
		}

		return response;
	}

	/**
	 * Method to activate the account. For now this hasn't been implemented.
	 */
	@Override
	public BaseResponse activate(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to fetch all account details. this method requires account id as
	 * parameter and return all account related information in AccountDto object
	 * type.
	 * 
	 * Fetching all transactions associated with account is not implemented for
	 * now.
	 */
	@Override
	public AccountDto fetch(String accountId) {
		Account account = accountRepository.findById(accountId);
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setName(account.getName());
		// TODO get all transaction for this account. not in scope for now.

		return accountDto;
	}

	/**
	 * Method to update account information. For now, System allow to update
	 * only balance. Other details like name, type all that cannot be updated
	 * once created.
	 */
	@Override
	public BaseResponse update(AccountDto request) {
		Account account = accountRepository.findById(request.getAccountId());
		if (account != null) {
			account.setBalance(request.getBalance());
			accountRepository.save(account);
		}
		BaseResponse response = new BaseResponse();
		response.setMessage("Account has been saved successfully");
		return response;
	}

	/**
	 * Method to delete the account. To maintain the history of account system
	 * will not actually delete the account instead it just update the account
	 * status to deleted.(soft delete)
	 */
	@Override
	public BaseResponse delete(String accountId) {
		Account account = accountRepository.findById(accountId);
		if (account != null) {
			account.setStatus(AccountStatus.DELETED.getValue());
			accountRepository.save(account);
		}
		BaseResponse response = new BaseResponse();
		response.setMessage("Account has been deleted successfully");
		return response;
	}

	/**
	 * Method to get the account balance. Amount in this systems are Euro cents.
	 * Client has to convert cents to Euro. In this way it will be easy for
	 * client user to convert currency based on their region and time zone.
	 */
	@Override
	public long getBalance(String accountId) {
		return accountRepository.getBalance(accountId);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
	}

}
