package com.gvp.swarajya;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NGO extends User {

	@Column(name="contact_person",length=45)
	private String contactPerson;

	@Column(name="phone_number",length=12)
	private String phoneNumber;

	public NGO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NGO(String contactPerson, String phoneNumber) {
		super();
		this.contactPerson = contactPerson;
		this.phoneNumber = phoneNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
