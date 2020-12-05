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

import com.proj.dao.RegisteredStudentDao;
import com.proj.model.RegisteredStudent;

public class RegisteredStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addRegisteredStudent.jsp";
	private static String EDIT = "/editRegisteredStudent.jsp";
	private static String LIST = "/listRegisteredStudent.jsp";//temper..

	private RegisteredStudentDao dao;

	public RegisteredStudentController() {
		super();
		dao = new RegisteredStudentDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			dao.deleteRegisteredStudent(studentId);
			forward = LIST;
			request.setAttribute("registeredStudents", dao.getAllRegisteredStudent());
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			RegisteredStudent registeredStudent = dao.getRegisteredStudentById(studentId);
			request.setAttribute("registeredStudent", registeredStudent);
		} else if (action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("registeredStudents", dao.getAllRegisteredStudent());
		} else if (action.equalsIgnoreCase("search")) {
			forward = LIST;
			String keyword = request.getParameter("keyword");
			request.setAttribute("registeredStudents", dao.getRegisteredStudentByKeyword(keyword));		
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
		 * the addStudent.jsp or the editStudent.jsp pages.
		 */
		
		RegisteredStudent registeredStudent = new RegisteredStudent();
		registeredStudent.setFirstName(request.getParameter("firstName"));
		registeredStudent.setLastName(request.getParameter("lastName"));
		try {
			Date registrationDate = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("registrationDate"));
			registeredStudent.setRegistrationDate(registrationDate);;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		registeredStudent.setFaculty(request.getParameter("faculty"));
		registeredStudent.setEmail(request.getParameter("email"));
		String studentId = request.getParameter("studentId");
		/**
		 * If the 'studentId' field in the form is empty, the new student will
		 * be added to the list of Student objects.
		 */
		if (studentId == null || studentId.isEmpty()) {
			dao.addRegisteredStudent(registeredStudent);;
		} else {
			/**
			 * Otherwise, if the field is already filled (this occurs when the
			 * user is trying to Edit A Student), then the student's information
			 * will be updated accordingly.
			 */
			registeredStudent.setStudentId(Integer.parseInt(studentId));
			dao.updateRegisteredStudent(registeredStudent);
		}
		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the listing of students.
		 */
		RequestDispatcher view = request
				.getRequestDispatcher(LIST);
		request.setAttribute("registeredStudents", dao.getAllRegisteredStudent());
		view.forward(request, response);
	}
}
