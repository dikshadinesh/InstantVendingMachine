package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.FridgeEntity;
import com.wissen.instantvendingmachine.repository.FridgeRepository;

public class FridgeRepositoryTest extends BaseTest {

	@Autowired
	private FridgeRepository fridgeRepository;

	@Test
	public void testFindAll() {
		List<FridgeEntity> fridge = fridgeRepository.findAll();
		fridge.forEach(System.out::println);
	}

}
