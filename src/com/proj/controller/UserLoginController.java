package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.Student;
import com.proj.dao.UserDao;
import com.proj.model.User;

public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String SIGNUP = "/sign_up.jsp";
	private static String ADMINLOGIN =  "/AdminLogin.jsp";
	
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
		
		// TODO: Add redirect for admin once that's done
		if (action.equalsIgnoreCase("signup")) {
			forward = SIGNUP;
		} else if (action.equalsIgnoreCase("adminlogin")){
			forward = ADMINLOGIN;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
				if (user.isSuspended()){
					response.sendRedirect("suspended.jsp");
				}else{
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", user);
					session.setAttribute("userId", user.getUserid());
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
