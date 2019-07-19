package com.wissen.instantvendingmachine.service;

import java.util.Scanner;

public class UserCheck {
	static Scanner sc = new Scanner(System.in);
	static String response;
	static LogIn lg = new LogIn();
	static Register rg = new Register();

	public static void userCheck() {
		System.out.println("Are you an existing user, or would you like to register?");
		response = sc.nextLine();
		if (response.equals("existing")) {
			lg.getInfo();
		} else if (response.equals("new")) {
			// rg.newUser();
		}
	}

}
