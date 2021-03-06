package com.proj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.proj.dao.*;
import com.proj.model.*;

@MultipartConfig
public class ListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String imagesBase = System.getProperty("user.dir") + File.separator + "listingImages";
	private static String INSERT = "/CreateNewList.jsp";
	private static String SEARCH_PAGE = "/SearchPage.jsp";
	private static String LISTING_DETAILS = "/ListingDetails.jsp";
	private static String EDIT = "/EditListing.jsp";
	private static String LOGIN_PAGE = "/index.jsp";
	private static String ALL_LISTINGS = "/Listing.jsp";
	private static String MY_LISTINGS = "/MyListing.jsp";
	
	private ListingDao dao;
	
	public ListingController() {
		super();
		dao = new ListingDao();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - delete will direct the servlet to let the user delete a student in
		 * the database. - insert will direct the servlet to let the user add a
		 * new student to the database. - edit will direct the servlet to let
		 * the user edit student information in the database. - listStudent will
		 * direct the servlet to the public listing of all students in the
		 * database. - listStudentAdmin will direct the servlet to the admin
		 * listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		} else if (action.equalsIgnoreCase("delete")){
			//You must pass in "listingId" inside the href when calling delete, otherwise won't work
			int listingId = Integer.parseInt(request.getParameter("listingId"));
			dao.deleteListing(listingId);
			forward = SEARCH_PAGE; // can update to whatever page we want user to go to after listing is deleted
		} else if (action.equalsIgnoreCase("listingdetails")) {
			forward = LISTING_DETAILS;
			int listingId = Integer.parseInt(request.getParameter("listingId"));
			request.setAttribute("listing", dao.getListingById(listingId));
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			int listingId = Integer.parseInt(request.getParameter("listingId"));
			request.setAttribute("listing", dao.getListingById(listingId));
		}else if (action.equalsIgnoreCase("listall")){
			forward = ALL_LISTINGS;
			request.setAttribute("listings", dao.getLisitngByKeyword(""));
		}else if (action.equalsIgnoreCase("listingfromuser")){
			int userId = Integer.parseInt(request.getParameter("userId"));
			forward = MY_LISTINGS;
			request.setAttribute("listings", dao.getLisitngByUser(userId));
		} else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
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
		listing.setUserId(user.getUserid());
		listing.setUsername(user.getUsername());
		
		//Files are uploaded in the folder "listingImages" under our working directory (assumed to be 350_webApp)
		Part filePart = request.getPart("listingImage");
		System.out.println("PARTS CHECK:" + filePart);
		
		if (filePart != null) {
			String fileName = getSubmittedFileName(filePart);
			String filePath = System.getProperty("user.dir") + File.separator + "listingImages" + File.separator+ fileName;
			System.out.println("FILEPATH CHECK:" + filePath);
			InputStream input = filePart.getInputStream();
			System.out.println("UPLOAD RESULT" + uploadFile(input, filePath));
			
			listing.setImagePath(filePath);
		} else {
			listing.setImagePath(null);
		}
	
		String listingId = request.getParameter("listingId");
		int result;
		
		if (listingId == null || listingId.isEmpty()) {
			result = dao.addListing(listing);
		} else {
			listing.setListingId(Integer.parseInt(listingId));
			result = dao.updateListing(listing);
		}
		
		
		
		// TODO: update to some errors page if result == 0 instead of login
		if (result == 0) {
			RequestDispatcher view = request
					.getRequestDispatcher(LOGIN_PAGE);
			view.forward(request, response);
		} else {
			RequestDispatcher view = request
					.getRequestDispatcher(SEARCH_PAGE);
			view.forward(request, response);
		}
		
	}

	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
	        }
	    }
	    return null;
	}
	
	private boolean uploadFile (InputStream input, String path) {
		try {
			int n;
			byte[] buffer=new byte[4096];
			FileOutputStream output = new FileOutputStream(path);
			do
			{
			    n=input.read(buffer);
			    if (n>0)
			    {
			        output.write(buffer, 0, n);
			    }
			}
			while (n>=0);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
