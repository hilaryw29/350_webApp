package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proj.model.*;
import com.proj.controller.*;
import com.mie.util.DbUtil;

public class UserDao {
	static Connection connection = null;
	static ResultSet rs = null; // For Login function
	
	public UserDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void addUser(User user) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into members(username,password,dob,phoneNum,region,email) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setDate(3, user.getDob());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getRegion());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
