package com.retail.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetail {

	@Id
	private int orderId;
	private int productId;
	private float quantity;
	private float total;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public OrderDetail(int orderId, int productId, float quantity, float total) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.total = total;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", total="
				+ total + "]";
	}
	
}
