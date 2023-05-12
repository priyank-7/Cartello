package com.retail.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
class ppk implements Serializable{
	private int productId;
	private String userId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ppk(int productId, String userId) {
		this.productId = productId;
		this.userId = userId;
	}
	public ppk() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ppk [productId=" + productId + ", userId=" + userId + "]";
	}
}

@Entity
public class WishList {


	@Id
	private ppk wl;
	
	
	public ppk getWl() {
		return wl;
	}
	public void setWl(ppk wl) {
		this.wl = wl;
	}
	public WishList(ppk wl) {
		this.wl = wl;
	}
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WishList [wl=" + wl + "]";
	}
	
	
}
