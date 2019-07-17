package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class EventEntity implements Serializable {

	private static final long serialVersionUID = 5197948311587745681L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Event_ID")
	private long eventID;
	@Column(name = "User_ID")
	private long userID;
	@Column(name = "Order_ID")
	private long orderID;
	@Column(name = "Item_ID")
	private long itemID;
	@Column(name = "Action")
	private String action;
	@Column(name = "Action_On_TRAY")
	private String actionOnTray;
	@Column(name = "Action_On_COMPARTMENT")
	private String actionOnCompartment;
	@Column(name = "Action_On_FRIDGE")
	private String actionOnFridge;
	@Column(name = "Timestamp")
	private Timestamp timestamp;

	public String getAction() {
		return action;
	}

	public String getActionOnCompartment() {
		return actionOnCompartment;
	}

	public String getActionOnFridge() {
		return actionOnFridge;
	}

	public String getActionOnTray() {
		return actionOnTray;
	}

	public long getEventID() {
		return eventID;
	}

	public long getItemID() {
		return itemID;
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

	public void setAction(String action) {
		this.action = action;
	}

	public void setActionOnCompartment(String actionOnCompartment) {
		this.actionOnCompartment = actionOnCompartment;
	}

	public void setActionOnFridge(String actionOnFridge) {
		this.actionOnFridge = actionOnFridge;
	}

	public void setActionOnTray(String actionOnTray) {
		this.actionOnTray = actionOnTray;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
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
		return "EventEntity [eventID=" + eventID + ", userID=" + userID + ", orderID=" + orderID + ", itemID=" + itemID
				+ ", action=" + action + ", actionOnTray=" + actionOnTray + ", actionOnCompartment="
				+ actionOnCompartment + ", actionOnFridge=" + actionOnFridge + ", timestamp=" + timestamp + "]";
	}

}
