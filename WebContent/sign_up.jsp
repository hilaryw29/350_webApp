
<%@ page language="java" contentType="text/html; charset=EUC-KR"
		 pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>MIE350 Sample Web App - sign up</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- Date Picker Javascript -->
	<!-- https://jqueryui.com/datepicker/ -->
	<link rel="stylesheet"
		  href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<style>
		.table-label {
			width: 200px;
			display: inline-block;
			text-align: right;
		}
	</style>
</head>
<body>



<div class="container-fluid text-center">
	<div class="row content">
		<div class="col-sm-2 sidenav">
			<!-- You can put left sidebar links here if you want to. -->
		</div>
		<div class="col-sm-8 text-left">
			<h1>Study Buddy Register Form</h1>
			<form action="UserController" method="post">
				<table style="with: 50%">
					<tr>
						<td>User ID (Not editable)</td>
						<td><input type="text" name="userId" readonly="readonly"></td>
					</tr>
					<tr>
						<td>U of T Email</td>
						<td><input type="text" name="email" placeholder="jane.dole@mail.utoronto.ca" pattern=".+@mail.utoronto.ca" required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="username" required></td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td><input type="date" name="dob" required></td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td><input type="text" name="phoneNum" placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required><br><small>Format: 123-456-7890</small></td>
					</tr>
					<tr>
						<td>Region Located</td>
						<td><input type="text" name="region" required></td>
					</tr></table>
				<input type="submit" value="create account" />
			</form>
		</div>
		<div class="col-sm-2 sidenav">
			<!-- You can put right sidebar links here if you want to. -->
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html> 
