package com.gvp.swarajya;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Farmer extends User {
	
	@Column(name="phone_number",length=12)
	private String phoneNumber;

	public Farmer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Farmer(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
