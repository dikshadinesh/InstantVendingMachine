package com.wissen.instantvendingmachine.dto;

public class ItemsBoughtInfoDto {
	private String action;
	private long itemID;
	private int quantity;

	public String getAction() {
		return action;
	}

	public long getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
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

	@Override
	public String toString() {
		return "itemsBoughtInfoDto [action=" + action + ", itemID=" + itemID + ", quantity=" + quantity + "]";
	}

}
