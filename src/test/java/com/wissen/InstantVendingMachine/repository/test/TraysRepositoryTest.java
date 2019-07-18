package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.TraysEntity;
import com.wissen.instantvendingmachine.repository.TraysRepository;

public class TraysRepositoryTest extends BaseTest {
	@Autowired
	private TraysRepository traysRepository;

	@Test
	public void testFindAll() {
		List<TraysEntity> trays = traysRepository.findAll();
		trays.forEach(System.out::println);
	}

}
