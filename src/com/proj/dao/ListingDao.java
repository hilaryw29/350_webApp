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
					.prepareStatement("insert into listings(title,description,price,category,image,userID,username) values (?, ?, ?, ?, ?, ?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, listing.getTitle());
			preparedStatement.setString(2, listing.getDescription());
			preparedStatement.setDouble(3, listing.getPrice());
			preparedStatement.setString(4, listing.getCategory());
			preparedStatement.setString(5, listing.getImagePath());
			preparedStatement.setInt(6, listing.getUserId());
			preparedStatement.setString(7, listing.getUsername());
			int result = preparedStatement.executeUpdate();
			
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateListing(Listing listing) { 
		/**
		 * This method adds a new listing to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update listings set title=?, description=?, price=?, category=?, image=?, username=?"
							+ " where listingID=?");
			// Parameters start with 1
			preparedStatement.setString(1, listing.getTitle());
			preparedStatement.setString(2, listing.getDescription());
			preparedStatement.setDouble(3, listing.getPrice());
			preparedStatement.setString(4, listing.getCategory());
			preparedStatement.setString(5, listing.getImagePath());
			preparedStatement.setString(6, listing.getUsername());
			preparedStatement.setInt(7, listing.getListingId());
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

	public List<Listing> getListingByCategory (String category){
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
				listing.setUsername(rs.getString("username"));
				listings.add(listing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listings;
	}

	public List<Listing> getLisitngByKeyword (String keyword){
		
		if(keyword == "Stationery" || keyword == "Textbooks" || keyword == "Hardware" || keyword == "Other"){
			return getListingByCategory(keyword);
		}
		
		/**
		 * This method retrieves a list of listing that matches the keyword
		 * entered by the user.
		 */
		List<Listing> listings = new ArrayList<Listing>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from listing where title LIKE ?");
			preparedStatement.setString(1,"%" + keyword + "%");
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
				listing.setUsername(rs.getString("username"));
				listings.add(listing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listings;
	}

	public Listing getListingById(int listingId) {
		Listing listing = new Listing();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from listings where listingID=?");

			preparedStatement.setInt(1, listingId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				listing.setListingId(rs.getInt("listingID"));
				listing.setTitle(rs.getString("title"));
				listing.setDescription(rs.getString("description"));
				listing.setPrice(rs.getDouble("price"));
				listing.setCategory(rs.getString("category"));
				listing.setImagePath(rs.getString("image"));
				listing.setUserId(rs.getInt("userID"));
				listing.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listing;
	}


}
