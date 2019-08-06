package com.wissen.instantvendingmachine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tray_compt")
public class TrayComptEntity {

	@Id
	@Column(name = "Tray_ID")
	private long trayID;
	@Column(name = "Compartment")
	private String compartment;

	public String getCompartment() {
		return compartment;
	}

	public long getTrayID() {
		return trayID;
	}

	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}

	public void setTrayID(long trayID) {
		this.trayID = trayID;
	}

	@Override
	public String toString() {
		return "TrayCompt [trayID=" + trayID + ", compartment=" + compartment + "]";
	}
}
