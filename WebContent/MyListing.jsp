<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.proj.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - All Students in DB</title>
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

<style type="text/css">	 
table#example {
    border-collapse: collapse;   
}
#example tr {
    background-color: #eee;
    border-top: 1px solid #fff;
}
#example tr:hover {
    background-color: #ccc;
}
#example th {
    background-color: #fff;
}
#example th, #example td {
    padding: 3px 5px;
}
#example td:hover {
    cursor: pointer;
}
</style> 

</head>

<body>

	<%@ include file="navbar.jsp"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Search Results For Listings</h1>

				The time is now <b><%=new java.util.Date()%></b>.<br> <br>

				The following listing information is displayed:
				<ul>
					<li>Title</li>
					<li>Price</li>
					<li>Description</li>
					<li>Category</li>
				</ul>
				
				<br /> The following <B><c:out
						value="${listings.size()}" /> listings</B> belongs to you: <br /> <br />
				
				<table id="example">
					<tr>
					    <th>&nbsp;</th>
					    <th>&nbsp;</th>
					    <th>Title</th>
						<th>Price</th>
						<th>Description</th>
						<th>Category</th>
					</tr>				
					<c:forEach items="${listings}" var="listing">
						<tr>
							<td><a href="ListingController?action=edit&listingId=${listing.getListingId()}">Edit</a></td>
							<td><a href="ListingController?action=delete&listingId=${listing.getListingId()}">Delete</a></td>
							<td align="center"><c:out value="${listing.getTitle()}" /></td>
							<td align="center"><c:out value="${listing.getPrice()}" /></td>
							<td align="center"><c:out value="${listing.getDescription()}" /></td>
							<td align="center"><c:out value="${listing.getCategory()}" /></td>
						</tr>
					</c:forEach>
				</table>

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