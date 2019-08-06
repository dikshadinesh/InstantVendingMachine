package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "items")

public class ItemsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_ID")
	private long itemID;
	@Column(name = "Item_Name")
	private String itemName;
	@Column(name = "Item_Price")
	private float itemPrice;
	@Column(name = "Item_Category")
	private String itemCategory;
	@Column(name = "Item_Weight")
	private float itemWeight;

	// lmao who knows
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Item_ID", referencedColumnName = "Item_ID", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private TraysEntity traysEntity;

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

	public float getItemWeight() {
		return itemWeight;
	}

	public TraysEntity getTraysEntity() {
		return traysEntity;
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

	public void setItemWeight(float itemWeight) {
		this.itemWeight = itemWeight;
	}

	public void setTraysEntity(TraysEntity traysEntity) {
		this.traysEntity = traysEntity;
	}

	@Override
	public String toString() {
		return "ItemsEntity [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemCategory=" + itemCategory + ", itemWeight=" + itemWeight + "]";
	}

}
