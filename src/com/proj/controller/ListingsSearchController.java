package com.proj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.ListingDao;
import com.proj.model.Listing;

public class ListingsSearchController extends HttpServlet {
    /**
     * This class only handles the SEARCH feature of the web app.
     *
     * These are variables that lead to the appropriate JSP pages.
     *
     * SEARCH_USER leads to the search results page.
     *
     */
    private static final long serialVersionUID = 1L;
    private static String SEARCH_USER = "/Listing.jsp";
    private ListingDao dao;

    /**
     * Constructor for this class.
     */
    public ListingsSearchController() {
        super();
        dao = new ListingDao();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /**
         * This method handles the retrieval of the search keyword entered by
         * the user.
         */
        String keyword = request.getParameter("keyword");

        RequestDispatcher view = request.getRequestDispatcher(SEARCH_USER);
        request.setAttribute("keyword", keyword);
        request.setAttribute("listings", dao.getLisitngByKeyword(keyword));
        /**
         * Redirect to the search results page after the list of students
         * matching the keywords has been retrieved.
         */

        view.forward(request, response);
    }
}
