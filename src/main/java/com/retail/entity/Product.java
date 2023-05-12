package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private float price;
	private String productName;
	private String productSize;
	private String productColor;
	private String imageUrl;
	private int categoryId;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Product(float price, String productName, String productSize, String productColor, String imageUrl,
			int categoryId) {
		this.price = price;
		this.productName = productName;
		this.productSize = productSize;
		this.productColor = productColor;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, float price, String productName, String productSize, String productColor,
			String imageUrl, int categoryId) {
		this.productId = productId;
		this.price = price;
		this.productName = productName;
		this.productSize = productSize;
		this.productColor = productColor;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", price=" + price + ", productName=" + productName
				+ ", productSize=" + productSize + ", productColor=" + productColor + ", imageUrl=" + imageUrl
				+ ", categoryId=" + categoryId + "]";
	}
	
	
	
	
	
}
