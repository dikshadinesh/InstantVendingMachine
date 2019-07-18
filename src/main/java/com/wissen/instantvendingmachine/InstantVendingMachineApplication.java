package com.wissen.instantvendingmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wissen.instantvendingmachine.service.UserCheck;

@SpringBootApplication
public class InstantVendingMachineApplication {

	public static void main(String[] args) {

		SpringApplication.run(InstantVendingMachineApplication.class, args);

		UserCheck.userCheck();
	}
}