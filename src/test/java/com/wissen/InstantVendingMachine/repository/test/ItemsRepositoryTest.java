package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.BaseTest;
import com.wissen.instantvendingmachine.entity.ItemsEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;

public class ItemsRepositoryTest extends BaseTest {
	@Autowired
	private ItemsRepository itemsRepository;

	@Test
	public void testFindAll() {
		List<ItemsEntity> items = itemsRepository.findAll();
		items.forEach(System.out::println);
	}

}
