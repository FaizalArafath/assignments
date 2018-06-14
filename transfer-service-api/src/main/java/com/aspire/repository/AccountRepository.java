/**
 * 
 */
package com.aspire.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aspire.common.AccountType;
import com.aspire.entity.Account;

/**
 * Account repository is responsible for all account related db activities.
 * 
 * @author faizal.arafath
 *
 */
public interface AccountRepository extends CrudRepository<Account, Integer>,
		JpaRepository<Account, Integer> {

	/**
	 * This method is used to fetch the account information. This will also lock
	 * the row to stop other threads to update/write. Lock will be release
	 * automatically when the transaction is being closed. *
	 * 
	 * @param accountId
	 * @return Account entity
	 */
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	Account findById(String accountId);

	/**
	 * Method to get balance available in the given account.
	 * 
	 * @param accountId
	 * @return
	 */
	@Query(value = "SELECT balance FROM Account a where a.id=?1")
	long getBalance(String accountId);

	/**
	 * Method to fetch account by its name and type. This is used when
	 * validating account while creating new account.
	 * 
	 * @param name
	 * @param type
	 * @return List of Account entities
	 */
	@Query(value = "SELECT a FROM Account a where a.name=?1 and a.type=?2")
	List<Account> fetchAccountNameAndType(String name, AccountType type);

}
