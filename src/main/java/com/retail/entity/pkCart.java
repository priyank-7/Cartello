package com.retail.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class pkCart implements Serializable {

	private String userId;
	private int productId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public pkCart(String userId, int productId) {
		this.userId = userId;
		this.productId = productId;
	}
	public pkCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "pkCart [userId=" + userId + ", productId=" + productId + "]";
	}
}
