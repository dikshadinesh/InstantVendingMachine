package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItemsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_ID")
	private long itemId;
	@Column(name = "Quantity")
	private int quantity;

	public long getItemId() {
		return itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemsEntity [itemId=" + itemId + ", quantity=" + quantity + "]";
	}

}
