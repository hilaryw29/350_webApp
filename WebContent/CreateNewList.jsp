<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
				<h1>Create New Listing</h1>

				<form method="post" action="ListingController" enctype='multipart/form-data' style="border: 1px solid black; padding: 10px;">
					<div style="display: inline-block; vertical-align: top;">
						<label class="table-label">Title:</label> <input type="text" name="title" /><br>
						<label class="table-label">Listing Description:</label> <input type="text" name="listDesc" /><br>
						<label class="table-label">Price:</label> <input type="number" name="price" /><br>
						<label class="table-label" for="study">Category:</label>
						<select name="category" id="category">
							<option value="Study Materials">Study Materials</option>
							<option value="Textbooks">Textbooks</option>
							<option value="Hardware">Hardware</option>
							<option value="Other">Other</option>
					  	</select>
						<br><br>
						<label class="table-label"></label><input type="submit" class="btn btn-info" value="Create Listing">
					</div>
					<div style="display: inline-block; vertical-align: top">
						<input type="file" text="Upload" placeholder="Image File" name="listingImage" accept="image/jpg, image/jpeg, image/png" />
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