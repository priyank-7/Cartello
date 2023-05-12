package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Helper1 {

	@Id
	private String userId;
	private String firstName;
	private String middelName;
	private String lastName;
	private String mobile1;
	private String mobile2;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String pinCode;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Helper1(String userId, String firstName, String middelName, String lastName, String mobile1, String mobile2,
			String address1, String address2, String city, String state, String country, String pinCode) {
		this.userId = userId;
		this.firstName = firstName;
		this.middelName = middelName;
		this.lastName = lastName;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}
	public Helper1(String firstName, String middelName, String lastName, String mobile1, String mobile2,
			String address1, String address2, String city, String state, String country, String pinCode) {
		this.firstName = firstName;
		this.middelName = middelName;
		this.lastName = lastName;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}
	public Helper1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Helper1 [userId=" + userId + ", firstName=" + firstName + ", middelName=" + middelName + ", lastName="
				+ lastName + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode
				+ "]";
	}
	
	
}
