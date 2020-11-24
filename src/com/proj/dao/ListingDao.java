package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Student;
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

	public int deleteListing(int listingID){
		/**
		 * This method deletes a listing from the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from listing where listingID=?");
			preparedStatement.setInt(1, listingID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Listing> getLisitngByCategory (String category){
		/**
		 * This method retrieves a list of listing that matches the category
		 * selected by the user.
		 */
		List<Listing> listings = new ArrayList<Listing>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from listing where category=?");

			preparedStatement.setString(1, category);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Listing listing = new Listing();
				listing.setListingId(rs.getInt("listingID"));
				listing.setTitle(rs.getString("title"));
				listing.setDescription(rs.getString("description"));
				listing.setPrice(rs.getDouble("price"));
				listing.setCategory(rs.getString("category"));
				listing.setImagePath(rs.getString("image"));
				listing.setUserId(rs.getInt("userID"));
				listings.add(listing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listings;
	}

	public List<Listing> getLisitngByKeyword (String keyword){
		/**
		 * This method retrieves a list of listing that matches the keyword
		 * entered by the user.
		 */
		List<Listing> listings = new ArrayList<Listing>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from listing where title LIKE ?");
			preparedStatement.setString(1, keyword);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Listing listing = new Listing();
				listing.setListingId(rs.getInt("listingID"));
				listing.setTitle(rs.getString("title"));
				listing.setDescription(rs.getString("description"));
				listing.setPrice(rs.getDouble("price"));
				listing.setCategory(rs.getString("category"));
				listing.setImagePath(rs.getString("image"));
				listing.setUserId(rs.getInt("userID"));
				listings.add(listing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listings;
	}


}