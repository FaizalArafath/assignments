/**
 * 
 */
package com.aspire.service;

import com.aspire.dto.BaseResponse;
import com.aspire.dto.TransactionDto;

/**
 * @author faizal.arafath
 *
 */
public interface TransferService {

	public BaseResponse transfer(TransactionDto request);
	
}
