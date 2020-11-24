<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - SearchPage</title>
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
	.goods-search {
		width: 100%;
		text-align: center;
	}
	.goods-table {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
	}
	.goods-cell {
		width: calc(50% - 5px);
		height: 90px;
		background: #ccc;
		margin-bottom: 10px;
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
				<div class="goods-search">
					<input type="text" placeholder="Search Textbox" name="searchValue" />
					<button>Search</button>
				</div>

				<div class="goods-table">
					<div class="goods-cell">Study Material</div>
					<div class="goods-cell">Textbooks</div>
					<div class="goods-cell">Hardware</div>
					<div class="goods-cell">Other</div>
				</div>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html> 