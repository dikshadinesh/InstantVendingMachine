package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_transaction")
public class PaymentTransactionEntity implements Serializable {

	private static final long serialVersionUID = -7033900097577473623L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_ID")
	private long transactionID;
	@Column(name = "Amount")
	private float amount;
	@Column(name = "Status")
	private String status;
	@Column(name = "Mode_of_Payment")
	private String modeOfPayment;

	public float getAmount() {
		return amount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	@Override
	public String toString() {
		return "PaymentTransactionEntity [transactionID=" + transactionID + ", amount=" + amount + ", status=" + status
				+ ", modeOfPayment=" + modeOfPayment + "]";
	}

}
