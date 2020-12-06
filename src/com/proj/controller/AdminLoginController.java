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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		Admin admin = new Admin();

		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));

		try {
			if (admin.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionAdminId", admin.getAdminId());

				response.sendRedirect("searchRegisteredStudent.jsp");
			}else {
				response.sendRedirect("invalidLogin.jsp");
			}
		}catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}

