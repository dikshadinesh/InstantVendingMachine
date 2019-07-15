package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.BaseTest;
import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

public class UserRepositoryTest extends BaseTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		List<UserEntity> users = userRepository.findAll();
		users.forEach(System.out::println);
	}

	@Test
	public void testSave() {

		UserEntity entity = new UserEntity();
		entity.setPhoneNumber(9901871876l);
		entity.setUserName("Neil");
		entity = userRepository.save(entity);
		System.out.println(entity);
	}
}