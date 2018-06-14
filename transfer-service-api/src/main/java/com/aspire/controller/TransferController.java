/**
 * 
 */
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
 * @author faizal.arafath
 *
 */
@RestController
@RequestMapping("/transfer-api")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<BaseResponse> update(@RequestBody TransactionDto request) {
		BaseResponse response =  transferService.transfer(request);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	
	
}
