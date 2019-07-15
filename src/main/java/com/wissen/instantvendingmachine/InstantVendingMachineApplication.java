package com.wissen.instantvendingmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class InstantVendingMachineApplication {
	static Connection conn = null;
	static PreparedStatement prepstat = null;

	public static void main(String[] args) {
		SpringApplication.run(InstantVendingMachineApplication.class, args);

		/*
		 * try { makeJDBCConnection();
		 * log("\n---------- Adding data to the user table----------");
		 * addDataToDB(9999, "olaolao", 990187189); prepstat.close(); conn.close();
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * private static void makeJDBCConnection() {
		 * 
		 * try { Class.forName("com.mysql.jdbc.Driver");
		 * log("Congrats - Seems your MySQL JDBC Driver Registered!"); } catch
		 * (ClassNotFoundException e) {
		 * log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly"
		 * ); e.printStackTrace(); return; }
		 * 
		 * try { // DriverManager: The basic service for managing a set of JDBC drivers.
		 * conn = DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/instant_vending_machine", "springuser",
		 * "ThePassword"); if (conn != null) {
		 * log("Connection Successful! Enjoy. Now it's time to push data"); } else {
		 * log("Failed to make connection!"); } } catch (SQLException e) {
		 * log("MySQL Connection Failed!"); e.printStackTrace(); return; } }
		 * 
		 * private static void addDataToDB(int User_ID, String User_Name, long
		 * Phone_Number) {
		 * 
		 * try { String insertQueryStatement = "INSERT  INTO user  VALUES  (?,?,?)";
		 * 
		 * prepstat = conn.prepareStatement(insertQueryStatement); prepstat.setInt(1,
		 * User_ID); prepstat.setString(2, User_Name); prepstat.setLong(3,
		 * Phone_Number);
		 * 
		 * 
		 * // execute insert SQL statement prepstat.executeUpdate(); log(User_Name +
		 * " added successfully"); } catch (
		 * 
		 * SQLException e) { e.printStackTrace(); } }
		 * 
		 * 
		 * 
		 * private static void log(String string) { System.out.println(string);
		 * 
		 * }
		 */
	}
}