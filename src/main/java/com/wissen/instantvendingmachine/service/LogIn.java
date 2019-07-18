package com.wissen.instantvendingmachine.service;

import java.util.Scanner;

public class LogIn {
	Scanner sc = new Scanner(System.in);
	String name;
	long phNumber;
	String response;

	public void getInfo() {
		System.out.println("Login to start Shopping!");
		System.out.println("Username : ");
		name = sc.nextLine();
		System.out.println("Phone Number : ");
		phNumber = sc.nextLong();
	}

}
