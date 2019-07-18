package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.OrderItemsEntity;
import com.wissen.instantvendingmachine.repository.OrderItemsRepository;

public class OrderItemsRepositoryTest extends BaseTest {
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Test
	public void testFindAll() {
		List<OrderItemsEntity> order_items = orderItemsRepository.findAll();
		order_items.forEach(System.out::println);
	}

}
