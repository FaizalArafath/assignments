package com.aspire.unit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aspire.dto.BaseResponse;
import com.aspire.dto.TransactionDto;
import com.aspire.repository.AccountRepository;
import com.aspire.repository.TransferRepository;
import com.aspire.service.impl.TransferServiceImpl;

/**
 * This class is to test the service transfer with various input parameters.
 * 
 * @author faizal.arafath
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TransferServiceMockTest {
	@Mock
	private AccountRepository accountRepository;

	@Mock
	private TransferRepository transferRepository;

	@InjectMocks
	private TransferServiceImpl transferService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Method to test positive flow of transfer with all input are correct.
	 */
	@Test
	public void testTransfer() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAmount(1000);
		transactionDto.setFromAccount("");
		transactionDto.setToAccount("");
		BaseResponse response = transferService.transfer(transactionDto);
		assertEquals("Transfered successfully", response.getMessage());
	}

	/**
	 * Method to test transfer with no amount passed. If no amount is passed it
	 * will be zero and one cannot transfer zero money to other.
	 */
	@Test
	public void testTransferWithoutAmount() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setFromAccount("");
		transactionDto.setToAccount("");
		BaseResponse response = transferService.transfer(transactionDto);
		assertEquals("Invalid amount", response.getMessage());
	}

	/**
	 * Method to test transfer service with inactive ToAccount. In active in the
	 * sense, account may be suspended or deleted or may be not activated yet.
	 */
	@Test
	public void testTransferWithInactiveToAccount() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAmount(1000);
		transactionDto.setFromAccount("");
		transactionDto.setToAccount("");
		BaseResponse response = transferService.transfer(transactionDto);
		assertEquals("To account is invalid", response.getMessage());
	}
	
	/**
	 * Method to test transfer service with inactive fromAccount. In active in the
	 * sense, account may be suspended or deleted or may be not activated yet.
	 */
	@Test
	public void testTransferWithInactiveFromAccount() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAmount(1000);
		transactionDto.setFromAccount("");
		transactionDto.setToAccount("");
		BaseResponse response = transferService.transfer(transactionDto);
		assertEquals("From account is invalid", response.getMessage());
	}

	/**
	 * Method to test the transfer method with insufficient balance. To do a
	 * transfer account balance should be greater than equal to the amount
	 * transferring.
	 */
	@Test
	public void testTransferWithInsufficientBal() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAmount(1000);
		transactionDto.setFromAccount("");
		transactionDto.setToAccount("");
		BaseResponse response = transferService.transfer(transactionDto);
		assertEquals("Account has insufficient balance", response.getMessage());
	}

}
