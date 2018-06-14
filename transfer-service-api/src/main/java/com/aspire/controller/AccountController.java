package com.aspire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.dto.AccountCreationRequest;
import com.aspire.dto.AccountCreationResponse;
import com.aspire.dto.AccountDto;
import com.aspire.dto.BaseResponse;
import com.aspire.service.AccountService;

/**
 * End point which controls all requests which are related to account. Account
 * controller will call appropriate service and get the result back as response.
 * Response will have response code, message if something has to be return back
 * and requested result set.
 * 
 * @author faizal.arafath
 *
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	/**
	 * 
	 */
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountCreationResponse> create(@RequestBody AccountCreationRequest request) {
		AccountCreationResponse response = accountService.create(request);
		return new ResponseEntity<AccountCreationResponse>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/activate/{accountId}", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> activate(@PathVariable String accountId) {
		BaseResponse response = accountService.activate(accountId);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> update(@RequestBody AccountDto request) {
		BaseResponse response = accountService.update(request);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> fetch(@PathVariable String accountId) {
		AccountDto accountDto = accountService.fetch(accountId);
		return new ResponseEntity<AccountDto>(accountDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{accountId}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse> delete(@PathVariable String accountId) {
		AccountDto account = accountService.fetch(accountId);
		if (account == null) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setMessage("Unable to delete. Account with id " + accountId + " not found.");
			return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
		}
		accountService.delete(accountId);
		return new ResponseEntity<BaseResponse>(HttpStatus.NO_CONTENT);
	}

}
