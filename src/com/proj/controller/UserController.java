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
import javax.servlet.http.HttpSession;

import com.mie.model.Student;
import com.proj.dao.RegisteredStudentDao;
import com.proj.dao.UserDao;
import com.proj.model.RegisteredStudent;
import com.proj.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/sign_up.jsp";
	private static String LOGIN_PAGE = "/index.jsp";
	private static String EDIT = "/EditAccount.jsp"; 
	private static String SEARCH_PAGE = "/SearchPage.jsp";
	private static String LIST = "/listUser.jsp";
	private static String NOT_REGISTERED = "/notRegistered.jsp";
	
	private UserDao dao;

	/**
	 * Constructor for this class.
	 */
	public UserController() {
		super();
		dao = new UserDao();
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
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
		} else if (action.equalsIgnoreCase("search")){
			forward = LIST;
			String keyword = request.getParameter("keyword");
			request.setAttribute("users", dao.getUserByKeyword(keyword));	
		} else if (action.equalsIgnoreCase("suspend")){
			forward = LIST;
			int userId = Integer.parseInt(request.getParameter("userId"));
			int adminId = Integer.parseInt(request.getParameter("adminId"));
			String reason = request.getParameter("reason");
			System.out.println(userId + reason);
			System.out.println(adminId);
			
			dao.suspendUser(userId, adminId, reason);	
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the newUser.jsp or the editUser.jsp pages.
		 */
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request
					.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setPhoneNumber(request.getParameter("phoneNum"));
		user.setRegion(request.getParameter("region"));
		user.setEmail(request.getParameter("email"));
		String userId = request.getParameter("userId");
		/**
		 * Add in if/else statement only if we plan on using this same controller/page for editing
		 * user account info as well.
		 */
		boolean newUser = false;
		boolean notRegistered = false;
		if (userId == null || userId.isEmpty()) {
			newUser = true;
			RegisteredStudentDao registeredStudent = new RegisteredStudentDao();
			
			if (registeredStudent.checkRegisteredStudentByEmail(user.getEmail())) {
				System.out.println("REGISTERED STUDENT NOT NULL");
				dao.addUser(user);
			} else {
				//We notify user that their u of t email cannot be found in the database
				System.out.println("REGISTERED STUDENT IS NULL");
				notRegistered = true;
			}
		} else {
			user.setUserid(Integer.parseInt(userId));
			
			// If user is updated successfully, update session attributes
			if (dao.updateUser(user)) {
				// Updates 
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				session.setAttribute("userId", user.getUserid());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("phoneNum", user.getPhoneNumber());
				session.setAttribute("region", user.getRegion());
				session.setAttribute("dob", user.getDob());
			}
			
		}
				
		

		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the login page.
		 */
		RequestDispatcher view;
		if (newUser) {
			if (notRegistered) {
				view = request
						.getRequestDispatcher(NOT_REGISTERED);
			} else {
				view = request
						.getRequestDispatcher(LOGIN_PAGE);
			}
		} else {
			view = request
					.getRequestDispatcher(SEARCH_PAGE);
		}
		
		view.forward(request, response);
	}

}
