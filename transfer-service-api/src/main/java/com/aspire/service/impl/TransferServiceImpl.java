/**
 * 
 */
package com.aspire.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.common.AccountStatus;
import com.aspire.dto.BaseResponse;
import com.aspire.dto.TransactionDto;
import com.aspire.entity.Account;
import com.aspire.entity.Transfer;
import com.aspire.repository.AccountRepository;
import com.aspire.repository.TransferRepository;
import com.aspire.service.TransferService;

/**
 * @author faizal.arafath
 *
 */
@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransferRepository transferRepository;

	@Override
	public BaseResponse transfer(TransactionDto request) {
		// TODO find a solution to handle simultaneous transfer request.
		Account fromAccount = accountRepository.findById(request.getFromAccount());
		Account toAccount = accountRepository.findById(request.getToAccount());
		String message = null;
		BaseResponse response = new BaseResponse();
		// Validate before transfer
		long amountToTransfer = request.getAmount();
		boolean validTransaction = transferValidation(fromAccount, toAccount, amountToTransfer, message);
		if (validTransaction) {
			// Fund transfer
			Transfer transfer = new Transfer();
			transfer.setFromAccount(fromAccount);
			transfer.setToAccount(toAccount);
			transfer.setAmount(request.getAmount());
			transfer.setStatus(0);
			// Reduce amount from the account balance
			long debitedBalance = fromAccount.getBalance() - amountToTransfer;
			long creditedBalance = toAccount.getBalance() + amountToTransfer;
			fromAccount.setBalance(debitedBalance);
			toAccount.setBalance(creditedBalance);
			List<Account> accounts = new ArrayList<>();
			accounts.add(toAccount);
			accounts.add(fromAccount);
			accountRepository.saveAll(accounts);
			transferRepository.save(transfer);
			message = "Transfered successfully";

		}
		response.setMessage(message);

		return response;
	}

	private boolean transferValidation(Account fromAccount, Account toAccount, long amountToTransfer, String message) {
		//Validate to account is active
		boolean isToAccountActive = toAccount.getStatus() == AccountStatus.ACTIVE.getValue();
		boolean isFromAccountActive = fromAccount.getStatus() == AccountStatus.ACTIVE.getValue();
		if(!isToAccountActive) {
			message = "To account is invalid";
		} else if(!isFromAccountActive) {
			message = "From account is invalid";
		} else if(fromAccount.getBalance() < amountToTransfer) {
			message = "Account has insufficient balance";
		}
		boolean isValid = message==null;
		return isValid;
	}

}
