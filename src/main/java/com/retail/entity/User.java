package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class User {

	@Id
	@NotNull(message = "cannot br null")
	private String userId;
	
	@NotNull(message = "cannot be null")
	private String userEmail;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userId, String userEmail, String password) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", password=" + password + "]";
	}
	
	
	
}
