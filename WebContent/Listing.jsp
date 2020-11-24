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
	
	a {
	  text-decoration: none;
	  display: inline-block;
	  padding: 8px 16px;
	}
	
	a:hover {
	  background-color: #ddd;
	  color: black;
	}
	
	.previous {
	  background-color: #f1f1f1;
	  color: black;
	}
	
	.next {
	  background-color: #4CAF50;
	  color: white;
	}
	
	.round {
	  border-radius: 50%;
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
				<h1>Listing</h1>
				<form style="border: 1px solid black; padding: 10px;">
					<div class="row">
					    <div class="col-sm-6 col-md-6 col-lg-6">
					         <div class="thumbnail">
					            <img src="/wp-content/uploads/2014/06/kittens.jpg" 
					             alt="a">
					            <div class="caption">
					                <p>
					                	Title
					                	Price
					                </p>
					                <p>
					                    <a href="#" class="btn btn-primary" role="button">
					                  		a
					                    </a> 
					                    <a href="#" class="btn btn-default" role="button">
					                    	a    
					                    </a>
					                </p>
					            </div>
					         </div>
					    </div>
					    <div class="col-sm-6 col-md-3 col-lg-6">
				        <div class="thumbnail">
				            <img src="/wp-content/uploads/2014/06/kittens.jpg" 
				            alt="a">
				            <div class="caption">
				                <p>
				                	Title
				                	Price
				                </p>
				                <p>
				                    <a href="#" class="btn btn-primary" role="button">
				                  		a
				                    </a> 
				                    <a href="#" class="btn btn-default" role="button">
				                    	a    
				                    </a>
				                </p>
				            </div>
				        </div>
				    </div>
			    	</div>
				    <div class="row">
					    <div class="col-sm-6 col-md-6 col-lg-6">
					        <div class="thumbnail">
					            <img src="/wp-content/uploads/2014/06/kittens.jpg" 
					            alt="z">
					            <div class="caption">
					                <p>
					                	Title
					                	Price
					                </p>
					                <p>
					                    <a href="#" class="btn btn-primary" role="button">
					                  		a
					                    </a> 
					                    <a href="#" class="btn btn-default" role="button">
					                    	a    
					                    </a>
					                </p>
					            </div>
					        </div>
					    </div>
					    <div class="col-sm-6 col-md-6 col-lg-6">
					        <div class="thumbnail">
					            <img src="/wp-content/uploads/2014/06/kittens.jpg" 
					            alt="z">
					            <div class="caption">
					                <p>
					                	Title
					                	Price
					                </p>
					                <p>
					                    <a href="#" class="btn btn-primary" role="button">
					                        z
					                    </a> 
					                    <a href="#" class="btn btn-default" role="button">
					                        z
					                    </a>
					                </p>
					            </div>
					        </div>
					    </div>
				</div>
				<a href="#" class="previous">&laquo; Previous</a>
				<a href="#" class="next">Next &raquo;</a>
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