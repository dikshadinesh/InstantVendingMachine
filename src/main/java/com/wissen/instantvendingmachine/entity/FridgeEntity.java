package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fridge")
public class FridgeEntity implements Serializable {
	private static final long serialVersionUID = -4405818278010753016L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Fridge_ID")
	private long fridgeID;
	@Column(name = "Area_Code")
	private long areaCode;

	public long getAreaCode() {
		return areaCode;
	}

	public long getFridgeID() {
		return fridgeID;
	}

	public void setAreaCode(long areaCode) {
		this.areaCode = areaCode;
	}

	public void setFridgeID(long fridgeID) {
		this.fridgeID = fridgeID;
	}

	/*
	 * @Override public String toString() { return
	 * "FridgeEntity["fridgeID=" + fridgeID + "areaCode=" + areaCode ]"; }
	 */
}
