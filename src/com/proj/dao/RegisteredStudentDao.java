package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mie.util.DbUtil;
import com.proj.model.RegisteredStudent;

public class RegisteredStudentDao {

	private Connection connection;

	public RegisteredStudentDao() {
		connection = DbUtil.getConnection();
	}

	public void addRegisteredStudent(RegisteredStudent registeredStudent) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into registeredStudents(firstName,lastName,registrationDate,faculty,email) values (?, ?, ?, ?, ? )");
			preparedStatement.setString(1, registeredStudent.getFirstName());
			preparedStatement.setString(2, registeredStudent.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(registeredStudent.getRegistrationDate().getTime()));
			preparedStatement.setString(4, registeredStudent.getFaculty());
			preparedStatement.setString(5, registeredStudent.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRegisteredStudent(int studentId) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from registeredStudents where studentId=?");
			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRegisteredStudent(RegisteredStudent registeredStudent) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update registeredStudents set firstName=?, lastName=?, registrationDate=?, faculty=?, email=?"
							+ " where studentId=?");
			preparedStatement.setString(1, registeredStudent.getFirstName());
			preparedStatement.setString(2, registeredStudent.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(registeredStudent.getRegistrationDate().getTime()));
			preparedStatement.setString(4, registeredStudent.getFaculty());
			preparedStatement.setString(5, registeredStudent.getEmail());
			preparedStatement.setInt(6, registeredStudent.getStudentId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RegisteredStudent> getAllRegisteredStudent() {

		List<RegisteredStudent> registeredStudents = new ArrayList<RegisteredStudent>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from registeredStudents");
			while (rs.next()) {
				RegisteredStudent registeredStudent = new RegisteredStudent();
				registeredStudent.setStudentId(rs.getInt("studentId"));
				registeredStudent.setFirstName(rs.getString("firstName"));
				registeredStudent.setLastName(rs.getString("lastName"));
				registeredStudent.setRegistrationDate(rs.getDate("registrationDate"));
				registeredStudent.setFaculty(rs.getString("faculty"));
				registeredStudent.setEmail(rs.getString("email"));
				registeredStudents.add(registeredStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return registeredStudents;
	}

	public RegisteredStudent getRegisteredStudentById(int studentId) {

		RegisteredStudent registeredStudent = new RegisteredStudent();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from registeredStudents where studentId=?");
			preparedStatement.setInt(1, studentId);
			
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				registeredStudent.setStudentId(rs.getInt("studentId"));
				registeredStudent.setFirstName(rs.getString("firstName"));
				registeredStudent.setLastName(rs.getString("lastName"));
				registeredStudent.setRegistrationDate(rs.getDate("registrationDate"));
				registeredStudent.setFaculty(rs.getString("faculty"));
				registeredStudent.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return registeredStudent;
	}

	public List<RegisteredStudent> getRegisteredStudentByKeyword(String keyword) {
		
		List<RegisteredStudent> registeredStudents = new ArrayList<RegisteredStudent>();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from registeredStudents where firstname LIKE ? OR lastname LIKE ? OR email LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				RegisteredStudent registeredStudent = new RegisteredStudent();
				registeredStudent.setStudentId(rs.getInt("studentId"));
				registeredStudent.setFirstName(rs.getString("firstName"));
				registeredStudent.setLastName(rs.getString("lastName"));
				registeredStudent.setRegistrationDate(rs.getDate("registrationDate"));
				registeredStudent.setFaculty(rs.getString("faculty"));
				registeredStudent.setEmail(rs.getString("email"));
				registeredStudents.add(registeredStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return registeredStudents;
	}

}
