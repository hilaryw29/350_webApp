<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - Login</title>
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

	<%@ include file="navbar.jsp"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Edit Your Listing Here</h1>

				<form method="post" action="ListingController"
					enctype='multipart/form-data'
					style="border: 1px solid black; padding: 10px;">
					<div
						style="display: inline-block; vertical-align: top; padding-bottom: 10px;">
						<label class="table-label">Listing ID (Not editable):</label> <input
							type="text" readonly="readonly" name="listingId"
							value="<c:out value="${listing.getListingId()}" />" /><br> <label
							class="table-label">Title:</label> <input type="text"
							name="title" value="<c:out value="${listing.getTitle()}" />" /><br>
						<label class="table-label">Listing Description:</label> <input
							type="text" name="description"
							value="<c:out value="${listing.getDescription()}" />" /><br>
						<label class="table-label">Price:</label> <input type="number"
							name="price" value="<c:out value="${listing.getPrice()}" />" /><br>
						<label class="table-label">Category:</label> <input type="text"
							name="category"
							value="<c:out value="${listing.getCategory()}" />" /><br>
						<!--label class="table-label">File:</label> <input type="file" text="upload" placeholder="Image File" name="listingImage" accept="image/jpg, image/jpeg, image/png" /-->
						<label class="table-label"></label><input type="submit"
							class="btn btn-info" value="confirm edited listing">
					</div>
					<div style="display: inline-block; vertical-align: top">
						<p>
							You have <b><c:out value="${listing.checkAssociatedImages()}" />
							</b> associated with this listing
						</p>
						<input type="file" text="Upload" placeholder="Image File"
							name="listingImage" accept="image/jpg, image/jpeg, image/png" />
						<p>Note: Your current image will be replaced if a new file is
							uploaded</p>
					</div>
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