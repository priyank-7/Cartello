package com.retail.helper;

import com.retail.entity.Product;

public class CartItems {

	private Product product;
	private Float quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public CartItems(Product product, Float quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItems [product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
