package com.wissen.instantvendingmachine.dto;

public class UpdatingTrayWeightsDto {
	private long trayID;
	private float trayWeight;

	public long getTrayID() {
		return trayID;
	}

	public float getTrayWeight() {
		return trayWeight;
	}

	public void setTrayID(long trayID) {
		this.trayID = trayID;
	}

	public void setTrayWeight(float trayWeight) {
		this.trayWeight = trayWeight;
	}

	@Override
	public String toString() {
		return "UpdatingTrayWeightsDto [trayID=" + trayID + ", trayWeight=" + trayWeight + "]";
	}

}
