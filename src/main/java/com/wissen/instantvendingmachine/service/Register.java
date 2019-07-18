package com.wissen.instantvendingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

@Service
public class Register {

	@Autowired
	private UserRepository userRepository;

	public void deleteUser(long phoneNumber) {
		/*
		 * UserEntity user = new UserEntity(); user.setPhoneNumber(99808088976l);
		 */
		userRepository.deleteById(phoneNumber);

	}

	public UserEntity newUser(String userName, long phoneNumber) {

		UserEntity user = new UserEntity();
		user.setPhoneNumber(phoneNumber);
		user.setUserName(userName);
		return userRepository.save(user);

	}
}
