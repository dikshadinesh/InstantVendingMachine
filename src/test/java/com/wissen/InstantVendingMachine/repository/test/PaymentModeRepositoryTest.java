package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.BaseTest;
import com.wissen.instantvendingmachine.entity.PaymentModeEntity;
import com.wissen.instantvendingmachine.repository.PaymentModeRepository;

public class PaymentModeRepositoryTest extends BaseTest {
	@Autowired
	private PaymentModeRepository paymentModeRepository;

	@Test
	public void testFindAll() {
		List<PaymentModeEntity> payment_mode = paymentModeRepository.findAll();
		payment_mode.forEach(System.out::println);
	}

}
