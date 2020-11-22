package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.proj.model.*;
import com.proj.controller.*;
import com.mie.util.DbUtil;

public class ListingDao {
	static Connection connection = null;
	
	public ListingDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public int addListing(Listing listing) { 
		/**
		 * This method adds a new listing to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into listings(title,description,price,category,image,userID) values (?, ?, ?, ?, ?, ?)");
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("insert into listings(title,description,price,category,userID) values (?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, listing.getTitle());
			preparedStatement.setString(2, listing.getDescription());
			preparedStatement.setDouble(3, listing.getPrice());
			preparedStatement.setString(4, listing.getCategory());
			preparedStatement.setString(5, listing.getImagePath());
			preparedStatement.setInt(6, listing.getUserId());
			int result = preparedStatement.executeUpdate();
			
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
