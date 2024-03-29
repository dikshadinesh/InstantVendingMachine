package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.OrderItemsEntity;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Long> {
}
