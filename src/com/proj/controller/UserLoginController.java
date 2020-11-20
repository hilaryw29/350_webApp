package com.proj.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDao;
import com.proj.model.User;

public class UserLoginController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered email and password from the login.jsp form.
		 */
		User user = new User();
		// TODO: Make sure to set the same parameter names on the form input in our login.jsp file
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		try {
			/**
			 * Try to see if the member can log in.
			 */
			user = UserDao.login(user);

			/**
			 * If the isValid value is true, assign session attributes to the
			 * current member.
			 */
			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionmember", user);
				session.setAttribute("username", user.getUsername());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("phoneNum", user.getPhoneNumber());
				session.setAttribute("region", user.getRegion());
				session.setAttribute("dob", user.getDob());
				/**
				 * TODO: Redirect to the members-only (listings??) page. Update redirect file.
				 * Redirecting to a random page (about.jsp) for now to check if login works.
				 */
				response.sendRedirect("SearchPage.jsp");

				/**
				 * Set a timeout variable of 900 seconds (15 minutes) for this
				 * member who has logged into the system.
				 */
				session.setMaxInactiveInterval(900);
			}

			else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
				response.sendRedirect("invalidLogin.jsp");
			}
		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
}
