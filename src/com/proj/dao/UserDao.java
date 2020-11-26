package com.proj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.proj.model.*;
import com.proj.controller.*;
import com.mie.model.Student;
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
	
	public static User login(User user) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String email = user.getEmail();
		String password = user.getPassword();

		/**
		 * Prepare a query that searches the users table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from users where email='"
				+ email + "' AND password='" + password + "'";

		try {
			// connect to DB
			connection = DbUtil.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the member to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				user.setValid(false);
			}

			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the User object.
			 */
			else if (more) {
				user.setUserid(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPhoneNumber(rs.getString("phoneNum"));
				user.setRegion(rs.getString("region"));
				user.setDob(rs.getDate("dob"));
				
				user.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the User object.
		 */
		return user;

	}
	
	public void addUser(User user) { 
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(username,password,dob,phoneNum,region,email) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getRegion());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// We might not need this, delete if unused
	public User getUserById (int userid) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where userID=?");
			preparedStatement.setInt(1, userid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userID"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPhoneNumber(rs.getString("phoneNum"));
				user.setRegion(rs.getString("region"));
				user.setDob(rs.getDate("dob"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
