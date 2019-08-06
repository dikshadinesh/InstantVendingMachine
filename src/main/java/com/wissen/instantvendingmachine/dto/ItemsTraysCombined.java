package com.wissen.instantvendingmachine.dto;

public class ItemsTraysCombined {

	private long itemID;
	private String itemName;
	private float itemPrice;
	private String itemCategory;
	private int itemQuantity;

	public ItemsTraysCombined(long itemID, String itemName, float itemPrice, String itemCategory, int itemQuantity) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
		this.itemQuantity = itemQuantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public long getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "ItemsTraysCombined [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemCategory=" + itemCategory + ", itemQuantity=" + itemQuantity + "]";
	}

}
// query = SELECT items.Item_ID, items.Item_Name, items.Item_Price, items.Item_Category, trays.Quantity FROM items INNER JOIN trays ON items.Item_ID = trays.Item_ID
