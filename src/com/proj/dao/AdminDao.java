package com.proj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.proj.model.*;
import com.proj.controller.*;
import com.mie.util.DbUtil;

public class AdminDao {
	static Connection connection = null;
	static ResultSet rs = null; // For Login function
	
	public AdminDao() {
		connection = DbUtil.getConnection();
	}
	
	public static boolean isValid(Admin admin) {

		Statement stmt = null;

		String email = admin.getEmail();
		String password = admin.getPassword();

		String searchQuery = "select * from admins where email='"
				+ email + "' AND password='" + password + "'";

		try {
			// connect to DB
			connection = DbUtil.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				return false;
			}else{
				return true;
			}
		}catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		
		return false;
	}
}