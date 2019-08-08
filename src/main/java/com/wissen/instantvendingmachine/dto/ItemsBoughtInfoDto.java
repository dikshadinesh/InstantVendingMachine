package com.wissen.instantvendingmachine.dto;

public class ItemsBoughtInfoDto {
	private String action;
	private long itemID;

	private int quantity;
	private float total;

	public String getAction() {
		return action;
	}

	public long getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ItemsBoughtInfoDto [action=" + action + ", itemID=" + itemID + ", quantity=" + quantity + ", total="
				+ total + "]";
	}

}
