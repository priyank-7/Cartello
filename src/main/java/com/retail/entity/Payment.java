package com.retail.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private int paymentMethodId;
	private Timestamp paymentDate;
	private String customerId;
	
	public Payment(int paymentId, int paymentMethodId, Timestamp paymentDate, String customerId) {
		this.paymentId = paymentId;
		this.paymentMethodId = paymentMethodId;
		this.paymentDate = paymentDate;
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment(int paymentId, int paymentMethodId, Timestamp paymentDate) {
		this.paymentId = paymentId;
		this.paymentMethodId = paymentMethodId;
		this.paymentDate = paymentDate;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMethodId=" + paymentMethodId + ", paymentDate="
				+ paymentDate + ", customerId=" + customerId + "]";
	}
}
