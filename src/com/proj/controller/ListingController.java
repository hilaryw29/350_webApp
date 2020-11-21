package com.proj.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.proj.dao.*;
import com.proj.model.*;

public class ListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/CreateNewList.jsp";
	
	private ListingDao dao;
	
	public ListingController() {
		super();
		dao = new ListingDao();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method retrieves all of the information entered in the form on
		 * the CreateNewList.jsp pages.
		 */
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		
		Listing listing = new Listing();
		listing.setTitle(request.getParameter("title"));
		listing.setDescription(request.getParameter("description"));
		listing.setPrice(Double.parseDouble(request.getParameter("price"))); 
		listing.setCategory(request.getParameter("category"));
		// TODO: UserId is never set. Need to get the userId somehow when the user logs in
		listing.setUserId(user.getUserid());
		
		Part filePart = request.getPart("listingImage");
		InputStream inputStream = null;
		if (filePart != null) {
			long fileSize = filePart.getSize();
			String fileContent = filePart.getContentType();
			inputStream = filePart.getInputStream();
		}
		listing.setImage(inputStream);
		
		dao.addListing(listing);
	}

	private String extractFileName(Part part) {
		return null;
	}
}
