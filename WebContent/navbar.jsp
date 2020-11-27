<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="SearchPage.jsp">StudyBuddy</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="SearchPage.jsp">Search Listings</a></li>
				<li><a href="CreateNewList.jsp">Create a Listing</a></li>
				<li><a href="Listing.jsp">All Listings</a></li>
				<li><a
					href="/mie350webapp/StudentController?action=listStudent">Student
						List (Public)</a></li>
				<li><a href="searchStudent.jsp">Search A Student</a></li>
				<li class="dropdown"><a data-toggle="dropdown">My Account<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/mie350webapp/UserController?action=edit">Edit Account Info</a></li>
						<li><a href="helpful_links.jsp">Another Related Page</a></li>
					</ul></li>
			</ul>
			<!-- The following code can be added to include a Login button to the right-hand side of the navbar-->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> 
			</ul>
		</div>
	</div>
</nav>