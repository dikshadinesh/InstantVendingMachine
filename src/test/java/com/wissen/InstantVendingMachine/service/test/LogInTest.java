package com.wissen.InstantVendingMachine.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.service.LogIn;

public class LogInTest {
	@Autowired
	private LogIn logIn;
	UserEntity newUser = new UserEntity();

	@Override
	@Test
	public void test() {
		newUser = register.newUser("lvbjhfbv", 99808088976l);
	}

}
