package com.wissen.instantvendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

@RestController
public class LogInController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user")
	public UserEntity verify(long phoneNumber) {
		return userRepository.getOneByPhoneNumber(phoneNumber);

	}

}
