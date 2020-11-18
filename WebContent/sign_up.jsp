<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UT Study Buddy</title>
</head>
<body>
<h1>Study Buddy Register Form</h1>
<form action="guru_register" method="post">
			<table style="with: 50%">
				<tr>
					<td>U of T Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="user_name" /></td>
				</tr>
					<tr>
					<td>Date of Birth</td>
					<td><input type="password" name="date_of_birth" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="phone_number" /></td>
				</tr>
				<tr>
					<td>Region Located</td>
					<td><input type="text" name="region_located" /></td>
				</tr></table>
			<input type="submit" value="create account" /></form>
</body>
</html>