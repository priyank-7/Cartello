package com.retail.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	private String userId;
	private int productId;
	private float rating;
	private String review;
	private Timestamp timestamp;
	
	
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Review(int reviewId, String userId, int productId, float rating, String review, Timestamp timestamp) {
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.review = review;
		this.timestamp = timestamp;
	}
	public Review(String userId, int productId, float rating, String review, Timestamp timestamp) {
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.review = review;
		this.timestamp = timestamp;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String userId, int productId, float rating, String review) {
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.review = review;
	}
	@Override
	public String toString() {
		return "Review [userId=" + userId + ", productId=" + productId + ", rating=" + rating + ", review=" + review
				+ ", timestamp=" + timestamp + "]";
	}

}
