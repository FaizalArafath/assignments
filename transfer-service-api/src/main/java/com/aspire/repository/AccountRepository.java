/**
 * 
 */
package com.aspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aspire.entity.Account;

/**
 * @author faizal.arafath
 *
 */
public interface AccountRepository extends CrudRepository<Account, Integer>, JpaRepository<Account, Integer> {

	Account findById(String accountId);
	
	@Query(value="SELECT balance FROM Account a where a.id=?1")
	long getBalance(String accountId);
	
	

}
