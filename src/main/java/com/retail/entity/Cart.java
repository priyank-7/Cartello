package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	private pkCart pkC;
	private float quantity;
	public pkCart getPrimary() {
		return pkC;
	}
	public void setPrimary(pkCart primary) {
		this.pkC = primary;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Cart(pkCart primary, float quantity) {
		this.pkC = primary;
		this.quantity = quantity;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [primary=" + pkC + ", quantity=" + quantity + "]";
	}
		
}
