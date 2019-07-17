package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrdersEntity implements Serializable {

	private static final long serialVersionUID = -3936859243248560668L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "Order_ID")
	private long orderID;
	@Column(name = "User_ID")
	private long userID;
	@Column(name = "Total_Price")
	private float itemPrice;
	@Column(name = "Time_stamp")
	private Timestamp timestamp;

	public float getItemPrice() {
		return itemPrice;
	}

	public long getOrderID() {
		return orderID;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public long getUserID() {
		return userID;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "OrdersEntity [orderID=" + orderID + ", userID=" + userID + ", itemPrice=" + itemPrice + ", timestamp="
				+ timestamp + "]";
	}

}
