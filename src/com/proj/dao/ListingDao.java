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
	
	public void addListing(Listing listing) { 
		/**
		 * This method adds a new listing to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into listings(userID,title,description,price,category,imagePath) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, listing.getUserId());
			preparedStatement.setString(2, listing.getTitle());
			preparedStatement.setString(3, listing.getDescription());
			preparedStatement.setDouble(4, listing.getPrice());
			preparedStatement.setString(5, listing.getCategory());
			preparedStatement.setBlob(6, listing.getImage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
