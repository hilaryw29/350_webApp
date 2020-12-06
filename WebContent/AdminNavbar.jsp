<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="searchRegisteredStudent.jsp">StudyBuddy</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="searchRegisteredStudent.jsp">Search A Student</a></li>
				<li><a href="/mie350webapp/RegisteredStudentController?action=list">All Registered Student</a></li>
				<li><a href="/mie350webapp/RegisteredStudentController?action=insert">New Registered Student</a></li>
				<li><a href="searchUser.jsp">Search User</a></li>
			</ul>
			<!-- The following code can be added to include a Login button to the right-hand side of the navbar-->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li> 
			</ul>
		</div>
	</div>
</nav>