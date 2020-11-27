package com.proj.model;

import java.io.File;
import java.io.InputStream;

public class Listing {
	
	private int listingId;
	private int userId;
	private String title;
	private String description;
	private double price;
	private String category;
	private String imagePath;
	private String username;
	
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getRelativeImagePath() {
		if (imagePath.isEmpty()) {
			return null;
		}
		String relativePath = imagePath.replace( System.getProperty("user.dir"), "");
		relativePath = relativePath.replace('\\', '/');
		System.out.println("RELATIVE IMAGE PATH" + relativePath);
		return relativePath;
	}
	public String checkAssociatedImages() {
		if (imagePath.isEmpty() || imagePath == null) {
			return "no images";
		}
		return "one image";
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Listing [userid=" + userId + ", listingId=" + listingId
				+ ", title=" + title + ", description=" + description + "]";
	}
	
	
}
