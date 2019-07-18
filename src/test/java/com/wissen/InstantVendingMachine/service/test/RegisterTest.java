package com.wissen.InstantVendingMachine.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.service.Register;

public class RegisterTest extends BaseTest {
	@Autowired
	private Register register;

	@Override
	@Test
	public void test() {

		UserEntity newUser = register.newUser("lvbjhfbv", 99808088976l);
		register.deleteUser(newUser.getUserId());

	}

}
