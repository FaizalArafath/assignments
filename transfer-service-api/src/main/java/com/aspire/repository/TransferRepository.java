package com.aspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspire.entity.Transfer;

;

/**
 * Transfer Repository is responsible for dealing with all transfer related db
 * operations.
 * 
 * @author faizal.arafath
 *
 */
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
