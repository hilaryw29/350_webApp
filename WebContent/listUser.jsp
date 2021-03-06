<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - All Registered Students in DB</title>
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
</head>
<body>

	<%@ include file="AdminNavbar.jsp"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Users from search search results</h1>

				The time is now <b><%=new java.util.Date()%></b>.<br> <br>

				The following User information is displayed:
				<ul>
					<li>User ID</li>
					<li>User Name</li>
					<li>Phone Number</li>
					<li>Email</li>
				</ul>

				<table border=1 class="sortable">
					<thead>
						<tr>
							<th>User ID</th>
							<th>User Name</th>
							<th>Phone Number</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td align="center"><c:out value="${user.getUserid()}" /></td>
								<td align="center"><c:out value="${user.getUsername()}" /></td>
								<td align="center"><c:out value="${user.getPhoneNumber()}" /></td>
								<td align="center"><c:out value="${user.getEmail()}" /></td>		
								<td><button onclick="myFunction(${user.getUserid()});">Suspend</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<script type="text/javascript">
                    function myFunction(id) {
                    	var reason = window.prompt("Enter Suspension Reason: ", "");
                    	window.location.href = "UserController?action=suspend&userId=" + id + "&reason=" + reason + "&adminId=" + "<%= session.getAttribute("currentSessionAdminId") %>";
                    }
                </script>

				<br /> <br />
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>