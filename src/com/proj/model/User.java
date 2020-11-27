package com.proj.model;

import java.util.Date;

public class User {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the User object.
	 */
	private int userId;
	private String username;
	private String password;
	private Date dob;
	private String phoneNum;
	private String region;
	private String email;
	private boolean valid;

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNum;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNum = phoneNumber;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userId + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
}
