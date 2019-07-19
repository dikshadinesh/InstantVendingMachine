package com.wissen.InstantVendingMachine.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.wissen.InstantVendingMachine.test.BaseTest;
//import com.wissen.instantvendingmachine.controller.DisplayItemsController;
import com.wissen.instantvendingmachine.entity.ItemsEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;

public class DisplayItemsControllerTest extends BaseTest {

	@Autowired
	private ItemsRepository itemsRepository;

	@Test
	public void displayTest() {
		List<ItemsEntity> items = itemsRepository.findAll();
		Assert.notEmpty(items, "");

	}

}
