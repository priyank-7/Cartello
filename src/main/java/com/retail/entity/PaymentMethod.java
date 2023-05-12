package com.retail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int methodId;
	private String methodType;
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public PaymentMethod(int methodId, String methodType) {
		this.methodId = methodId;
		this.methodType = methodType;
	}
	public PaymentMethod(String methodType) {
		this.methodType = methodType;
	}
	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PaymentMethod [methodId=" + methodId + ", methodType=" + methodType + "]";
	}
	
	
}
