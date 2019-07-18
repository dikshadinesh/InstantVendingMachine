package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.test.BaseTest;
import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

public class UserRepositoryTest extends BaseTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCheck() {
		UserEntity entity = new UserEntity();
		entity.setUserId(1234l);
		if (userRepository.existsById(1234l)) {
			System.out.println("yeeet");
		}
	}

	@Test
	public void testDelete() {
		UserEntity entity = new UserEntity();
		entity.setUserId(4l);
		userRepository.deleteById(4l);
		System.out.println(entity);
	}

	@Test
	public void testFindAll() {
		List<UserEntity> users = userRepository.findAll();
		users.forEach(System.out::println);
	}

	@Test
	public void testSave(/* String userName, long phoneNumber */) {

		UserEntity entity = new UserEntity();
		entity.setPhoneNumber(9901871877l);
		entity.setUserName("Diksha");
		entity = userRepository.save(entity);
		System.out.println(entity);
	}
}