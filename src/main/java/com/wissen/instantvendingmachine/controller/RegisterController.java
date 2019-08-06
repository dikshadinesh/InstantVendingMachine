package com.wissen.instantvendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

@RestController
public class RegisterController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	public UserEntity newUser(String userName, long phoneNumber) {

		UserEntity user = new UserEntity();
		user.setPhoneNumber(phoneNumber);
		user.setUserName(userName);
		return userRepository.save(user);

	}

}
