<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
}
button:hover {
  opacity: 0.8;
}
/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}
img.avatar {
  width: 40%;
  border-radius: 50%;
}
.container {
  padding: 16px;
}
span.psw {
  float: right;
  padding-top: 16px;
}
/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}
/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}
/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}
.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}
/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}
@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>

<title>MIE350 Sample Web App</title>
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

	<%@ include file="navbar.jsp"%>
	
	<div class="imgcontainer">
    	<img src="img/UofT.png" alt="Avatar" class="avatar">
  	</div>
	
	<section class="container">
	  	<div style="float: left; width: 50%">
	    	<label for="uname"><b>Admin Log in</b></label>
	    	
	    	<form method="post" action="UserLoginController">

					<b>U of T Email:</b> <input type="text" placeholder="Enter Email"  name="email" /><br><b>Password: </b><input
						type="password" placeholder="Enter Password"  name="password" /> <input type="submit"
						class="btn btn-info" value="Submit">

			</form>
		    <label>
		      <input type="checkbox" checked="checked" name="remember">       Remember me
		    </label>
		    <div>
		    	<span style="position: relative; top: 10px"><a href="#">Forgot password?</a></span>
		    </div>
  		</div>
  		<div style="float: left; width: 50%;">
  			
  		</div>	
	</section>



	<!-- 
	
	
		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-2 sidenav">
				</div>
				<div class="col-sm-8 text-left">
					<h1>Hello World!!</h1>
					<p>In this project, your team will design and build a web
						application. A web application is a software application that is
						accessed over the Internet using standard browsers (e.g. Internet
						Explorer, Mozilla Firefox). Examples of web application would be
						online-shopping, web banking, stock exchange and many others. Each
						member of the team is expected to contribute equally to the project
						though there may be a variety of different roles.</p>
					<hr>
					<h3>Internet Browsers</h3>
					<p>When designing your projects, please make sure to test them
						with the following browsers:
					<ul>
						<li>Google Chrome</li>
						<li>Mozilla Firefox</li>
						<li>Internet Explorer (or Microsoft Edge)</li>
					</ul>
					Please <b>do not rely on the built-in web browser in Eclipse</b> for
					testing. Cascading Style Sheet (CSS) templates will not render
					properly with Eclipse's built-in browser.
					</p>
				</div>
				<div class="col-sm-2 sidenav">
					
				</div>
			</div>
		</div>
		
	 -->
	
	<%@ include file="footer.jsp"%>

</body>
</html>