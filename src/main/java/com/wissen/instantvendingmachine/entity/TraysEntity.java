package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trays")

public class TraysEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Tray_ID")
	private long trayID;
	@Column(name = "Item_ID")
	private long itemID;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Current_Weight")
	private float currentWeight;

	public float getCurrentWeight() {
		return currentWeight;
	}

	public long getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public long getTrayID() {
		return trayID;
	}

	public void setCurrentWeight(float currentWeight) {
		this.currentWeight = currentWeight;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTrayID(long trayID) {
		this.trayID = trayID;
	}

	@Override
	public String toString() {
		return "TraysEntity [trayID=" + trayID + ", itemID=" + itemID + ", quantity=" + quantity + ", currentWeight="
				+ currentWeight + "]";
	}

}
