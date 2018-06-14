/**
 * 
 */
package com.aspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspire.entity.Transfer;;

/**
 * @author faizal.arafath
 *
 */
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
