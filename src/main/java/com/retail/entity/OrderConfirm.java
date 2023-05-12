package com.retail.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderConfirm {

	@Id
	private int orderId;
	private String customerId;
	private Date orderDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderConfirm(int orderId, String customerId, Date orderDate) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
	}
	public OrderConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + "]";
	}
	
}
