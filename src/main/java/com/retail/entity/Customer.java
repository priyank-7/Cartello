package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	private String customerId;
	
	@NotNull(message = "cannot be null")
	private String firstName;

	private String middelName;
	
	@NotNull(message = "cannot be null")
	private String lastName;
	
	@NotNull(message = "cannot be null")
	private String mobile1;
	private String mobile2;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddelName() {
		return middelName;
	}
	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public Customer(String customerId, String firstName, String middelName, String lastName, String mobile1,
			String mobile2) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.middelName = middelName;
		this.lastName = lastName;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
	}
	public Customer(String firstName, String middelName, String lastName, String mobile1, String mobile2) {
		this.firstName = firstName;
		this.middelName = middelName;
		this.lastName = lastName;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", middelName=" + middelName
				+ ", lastName=" + lastName + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + "]";
	}
	
	
	
}
