package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.BaseTest;
import com.wissen.instantvendingmachine.entity.OrdersEntity;
import com.wissen.instantvendingmachine.repository.OrdersRepository;

public class OrdersRepositoryTest extends BaseTest {
	@Autowired
	private OrdersRepository ordersRepository;

	@Test
	public void testFindAll() {
		List<OrdersEntity> orders = ordersRepository.findAll();
		orders.forEach(System.out::println);
	}

}
