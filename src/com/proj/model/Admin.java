package com.proj.model;

import java.util.Date;

import com.proj.dao.AdminDao;

public class Admin {
	private int adminId;
	private String email;
	private String userName;
	private String password;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid(){
		return AdminDao.isValid(this);
	}
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", userName="
				+ userName + ", password=" + password + "]";
	}
	

}
