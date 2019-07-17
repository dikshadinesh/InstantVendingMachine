package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.OrdersEntity;

@Repository

public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {

}
