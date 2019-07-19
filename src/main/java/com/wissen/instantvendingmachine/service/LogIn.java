package com.wissen.instantvendingmachine.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.entity.UserEntity;
import com.wissen.instantvendingmachine.repository.UserRepository;

@Service
public class LogIn {

	@Autowired
	private UserRepository userRepository;

	Scanner sc = new Scanner(System.in);
	String userName;
	long phoneNumber;
	String response;

	public void getInfo() {

		System.out.println("Login to start Shopping!");
		System.out.println("Username : ");
		userName = sc.nextLine();
		System.out.println("Phone Number : ");
		phoneNumber = sc.nextLong();
		verify(phoneNumber);

	}

	public void verify(long phoneNumber) {
		UserEntity user = new UserEntity();
		user.setPhoneNumber(phoneNumber);
		userRepository.getOneByPhoneNumber(phoneNumber);

	}

}
