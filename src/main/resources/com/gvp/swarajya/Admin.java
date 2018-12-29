package com.gvp.swarajya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@Column(name="email",length=45)
	private String email;

	@Column(name="full_name",length=45)
	private String fullName;
	@Column(name="password",length=15)
	private String password;
	
	
	
	public Admin(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [email=" + email + ", fullName=" + fullName + ", password=" + password + "]";
	}
	
	
}
