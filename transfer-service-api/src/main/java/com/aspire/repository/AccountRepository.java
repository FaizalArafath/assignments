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
 * @author faizal.arafath
 *
 */
public interface AccountRepository extends CrudRepository<Account, Integer>, JpaRepository<Account, Integer> {
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	Account findById(String accountId);
		
	@Query(value="SELECT balance FROM Account a where a.id=?1")
	long getBalance(String accountId);
	
	@Query(value="SELECT a FROM Account a where a.name=?1 and a.type=?2")
	List<Account> fetchAccountNameAndType(String name, AccountType type);
	
	
	
}
