package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.PaymentTransactionEntity;

@Repository

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransactionEntity, Integer> {

}
