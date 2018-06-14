package com.aspire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.dto.BaseResponse;
import com.aspire.dto.TransactionDto;
import com.aspire.service.TransferService;

/**
 * End point which controls all requests which are related to amount transfer.
 * Transfer controller will call appropriate service and get the result back as
 * response. Response will have response code, message if something has to be
 * return back and requested result set.
 * 
 * @author faizal.arafath
 *
 */
@RestController
@RequestMapping("/transfer-api")
public class TransferController {

	@Autowired
	private TransferService transferService;

	/**
	 * Method to transfer amount from one account to another. this method
	 * require TransactionDto object which hold required parameters like
	 * toAccount, fromAccount and amount.
	 * 
	 * @param request
	 * @return ResponseEntity of type Base Response
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> transfer(
			@RequestBody TransactionDto request) {
		BaseResponse response = transferService.transfer(request);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
