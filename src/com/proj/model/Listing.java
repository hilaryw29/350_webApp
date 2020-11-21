package com.proj.model;

import java.io.InputStream;

public class Listing {
	
	private int listingId;
	private int userId;
	private String title;
	private String description;
	private double price;
	private String category;
	private InputStream image;
	
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
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Listing [userid=" + userId + ", listingId=" + listingId
				+ ", title=" + title + ", description=" + description + "]";
	}
	
	
}
