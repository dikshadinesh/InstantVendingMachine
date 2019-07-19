package com.wissen.InstantVendingMachine.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;
import com.wissen.instantvendingmachine.service.Register;

public class RegisterTest extends BaseTest {
	@Autowired
	private Register register;
	UserEntity newUser = new UserEntity();
	@Autowired
	private UserRepository userRepository;

	/*
	 * @After public void destroy() { register.deleteUser(newUser.getUserId()); }
	 *
	 * @Before public void init() {
	 *
	 * }
	 */
	@Test
	public void testCheckExistance() {

		newUser = register.newUser("lvbjhfbv", 99808088976l);
		long phoneNumber = 99808088976l;
		userRepository.getOneByPhoneNumber(phoneNumber);

	}

}
