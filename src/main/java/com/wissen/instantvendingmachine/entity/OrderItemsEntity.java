package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItemsEntity implements Serializable {

	private static final long serialVersionUID = -5767354189722562638L;
	@Id
	@Column(name = "Item_ID")
	private long itemID;
	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Order_ID")
	private long orderID;

	public long getItemId() {
		return itemID;
	}

	public long getItemID() {
		return itemID;
	}

	public long getOrderID() {
		return orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setItemId(long itemID) {
		this.itemID = itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemsEntity [itemID=" + itemID + ", quantity=" + quantity + ", orderID=" + orderID + "]";
	}

}
