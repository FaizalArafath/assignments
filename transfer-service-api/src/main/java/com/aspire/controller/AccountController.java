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

	/**
	 * Method to create Account. It requires AccountCreationRequest object as
	 * parameter with required details to create account.
	 * 
	 * @param request
	 * @return ResponseEntity of type AccountCreationResponse
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountCreationResponse> create(
			@RequestBody AccountCreationRequest request) {
		AccountCreationResponse response = accountService.create(request);
		return new ResponseEntity<AccountCreationResponse>(response,
				HttpStatus.CREATED);
	}

	/**
	 * Method to activate the account. Usually activation URL will be called
	 * from account activation mail.
	 * 
	 * @param accountId
	 * @return ResponseEntity of type BaseResponse
	 */
	@RequestMapping(value = "/activate/{accountId}", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> activate(@PathVariable String accountId) {
		BaseResponse response = accountService.activate(accountId);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/**
	 * This method is used to update the account informations. For now API has
	 * ability to update only the account balance. All other information like
	 * account name, account id cannot be changed once created.
	 * 
	 * @param request
	 * @return ResponseEntity of type BaseResponse
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> update(@RequestBody AccountDto request) {
		BaseResponse response = accountService.update(request);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/**
	 * Method to fetch account information. It require accountId to be passed.
	 * This method is also capable of returning all associated transactions
	 * details for the account. For now only the skeleton has been made and
	 * transaction will not be return back to the response.
	 * 
	 * @param accountId
	 * @return ResponseEntity of type AccountDto
	 */
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> fetch(@PathVariable String accountId) {
		AccountDto accountDto = accountService.fetch(accountId);
		return new ResponseEntity<AccountDto>(accountDto, HttpStatus.OK);
	}

	/**
	 * Method to delete the account. It requires account id to be passed. Once
	 * the account is deleted user will be able to transfer or view account
	 * details.
	 * 
	 * @param accountId
	 * @return ResponseEntity of type BaseResponse
	 */
	@RequestMapping(value = "/delete/{accountId}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse> delete(@PathVariable String accountId) {
		AccountDto account = accountService.fetch(accountId);
		if (account == null) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setMessage("Unable to delete. Account with id "
					+ accountId + " not found.");
			return new ResponseEntity<BaseResponse>(baseResponse,
					HttpStatus.NOT_FOUND);
		}
		accountService.delete(accountId);
		return new ResponseEntity<BaseResponse>(HttpStatus.NO_CONTENT);
	}

}
