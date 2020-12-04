package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDao;
import com.proj.model.Admin;
import com.proj.model.User;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static String SIGNUP = "/sign_up.jsp";
//	private static String ADMINLOGIN =  "/AdminLogin.jsp";
//	
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		/**
//		 * This class retrieves the appropriate 'action' found on the JSP pages:
//		 * 
//		 * - delete will direct the servlet to let the user delete a student in
//		 * the database. - insert will direct the servlet to let the user add a
//		 * new student to the database. - edit will direct the servlet to let
//		 * the user edit student information in the database. - listStudent will
//		 * direct the servlet to the public listing of all students in the
//		 * database. - listStudentAdmin will direct the servlet to the admin
//		 * listing of all students in the database.
//		 */
//		String forward = "";
//		String action = request.getParameter("action");
//		
//		// TODO: Add redirect for admin once that's done
//		if (action.equalsIgnoreCase("signup")) {
//			forward = SIGNUP;
//		} else if (action.equalsIgnoreCase("adminlogin")){
//			forward = ADMINLOGIN;
//		}
//
//		RequestDispatcher view = request.getRequestDispatcher(forward);
//		view.forward(request, response);
//	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		Admin admin = new Admin();

		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));
		System.out.println(admin);

		try {
			if (admin.isValid()) {
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("invalidLogin.jsp");
			}
		}catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}

