/**
 * 
 */
package com.aspire.service;

import com.aspire.dto.BaseResponse;
import com.aspire.dto.TransactionDto;

/**
 * This interface exposes all operation that can be done in Transfer activity.
 * 
 * @author faizal.arafath
 *
 */
public interface TransferService {

	public BaseResponse transfer(TransactionDto request);

}
