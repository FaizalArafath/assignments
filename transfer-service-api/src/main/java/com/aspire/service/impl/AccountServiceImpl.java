/**
 * 
 */
package com.aspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * @author faizal.arafath
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountCreationResponse create(AccountCreationRequest request) {
		//validation to check the account name is already exist in the system
		List<Account> accounts = accountRepository.fetchAccountNameAndType(request.getName(), request.getType());
		AccountCreationResponse response = new AccountCreationResponse();
		if(accounts == null) {
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

	@Override
	public BaseResponse activate(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDto fetch(String accountId) {
		Account account = accountRepository.findById(accountId);
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setName(account.getName());
		//TODO get all transaction for this account. not in scope for now. 
		
		return accountDto;
	}

	//System allow to update only balance. Other details like name, type all that cannot be updated. 
	@Override
	public BaseResponse update(AccountDto request) {
		Account account = accountRepository.findById(request.getAccountId());
		if(account != null) {
			account.setBalance(request.getBalance());
			accountRepository.save(account);
		}
		BaseResponse response = new BaseResponse();
		response.setMessage("Account has been saved successfully");
		return response;
	}

	@Override
	public BaseResponse delete(String accountId) {
		Account account = accountRepository.findById(accountId);
		if(account != null) {
			account.setStatus(AccountStatus.DELETED.getValue());
			accountRepository.save(account);
		}
		BaseResponse response = new BaseResponse();
		response.setMessage("Account has been deleted successfully");
		return response;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getBalance(String accountId) {
		return accountRepository.getBalance(accountId);
	}


	

}
