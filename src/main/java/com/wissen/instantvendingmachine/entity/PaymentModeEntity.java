package com.wissen.instantvendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_mode")

public class PaymentModeEntity implements Serializable {

	private static final long serialVersionUID = -4517970221433581538L;
	@Id
	@Column(name = "Transaction_ID")
	private long transactionID;
	@Column(name = "Card_PayTM_Gpay")
	private String cardPayTMGpay;

	public String getCardPayTMGpay() {
		return cardPayTMGpay;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setCardPayTMGpay(String cardPayTMGpay) {
		this.cardPayTMGpay = cardPayTMGpay;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	@Override
	public String toString() {
		return "PaymentModeEntity [transactionID=" + transactionID + ", cardPayTMGpay=" + cardPayTMGpay + "]";
	}

}
