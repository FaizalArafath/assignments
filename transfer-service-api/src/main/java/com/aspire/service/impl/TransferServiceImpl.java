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
 * This class has the actual implementation and business logic for all
 * operations that are exposed for Transfer.
 * 
 * @author faizal.arafath
 *
 */
@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransferRepository transferRepository;

	/**
	 * Method to transfer amount from one account to another. it requires
	 * TransactionDto object type. which have toAccount, fromAccount amount to
	 * be transfered.
	 * 
	 * While fetching the account entity, the row will be locked for this
	 * transaction. Any other simultaneous request cannot access the row unless
	 * the first request close the transaction.
	 */
	@Override
	public BaseResponse transfer(TransactionDto request) {
		// Fetching account to check balance. This will put lock for the account
		// Row.
		Account fromAccount = accountRepository.findById(request
				.getFromAccount());
		Account toAccount = accountRepository.findById(request.getToAccount());
		String message = null;
		BaseResponse response = new BaseResponse();
		// Validate before transfer
		long amountToTransfer = request.getAmount();
		boolean validTransaction = transferValidation(fromAccount, toAccount,
				amountToTransfer, message);
		if (validTransaction) {
			// Fund transfer
			Transfer transfer = new Transfer();
			transfer.setFromAccount(fromAccount);
			transfer.setToAccount(toAccount);
			transfer.setAmount(request.getAmount());
			transfer.setStatus(0);
			// Reduce amount to fromAccount balance. add amount to toAccount
			// balance
			long debitedBalance = fromAccount.getBalance() - amountToTransfer;
			long creditedBalance = toAccount.getBalance() + amountToTransfer;
			fromAccount.setBalance(debitedBalance);
			toAccount.setBalance(creditedBalance);
			List<Account> accounts = new ArrayList<>();
			accounts.add(toAccount);
			accounts.add(fromAccount);
			// Persist entities with modified values.
			accountRepository.saveAll(accounts);
			transferRepository.save(transfer);
			message = "Transfered successfully";

		}
		response.setMessage(message);

		return response;
	}

	/**
	 * Method to validate account and account balance before doing fund
	 * transfer.
	 * 
	 * @param fromAccount
	 * @param toAccount
	 * @param amountToTransfer
	 * @param message
	 * @return boolean isValid or not
	 */
	private boolean transferValidation(Account fromAccount, Account toAccount,
			long amountToTransfer, String message) {
		
		// Validate to account is active
		boolean isToAccountActive = toAccount.getStatus() == AccountStatus.ACTIVE
				.getValue();
		boolean isFromAccountActive = fromAccount.getStatus() == AccountStatus.ACTIVE
				.getValue();
		if (!isToAccountActive) {
			message = "To account is invalid";
		} else if (!isFromAccountActive) {
			message = "From account is invalid";
		} else if (fromAccount.getBalance() < amountToTransfer) {
			message = "Account has insufficient balance";
		} else if (amountToTransfer <= 0){
			message = "Invalid amount";
		}
		boolean isValid = message == null;
		return isValid;
	}

}
