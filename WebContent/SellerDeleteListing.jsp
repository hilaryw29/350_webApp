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

<%@ include file="navbar.jsp"%>

<div class="container-fluid text-center">
	<div class="row content">
		<div class="col-sm-2 sidenav">
			<!-- You can put left sidebar links here if you want to. -->
		</div>
		<div class="col-sm-8 text-left">
			<h1>Manage Your Listing Here</h1>
			<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Listing Title</th>
      <th scope="col">Category</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
     <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
     <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
     <tr>
      <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
    <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
    <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
   <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>
    <tr>
     <th scope="row">value="<c:out value="${listing.title}" />"</th>
      <td>value="<c:out value="${listing.category}" />"</td>
      <td><!-- Button trigger modal -->
					                    <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#DeletePopup" role="button">
					                    	delete    
					                    </a>
					                    <!-- Modal -->
<div class="modal fade" id="DeletePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">WARNING!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger">Yes</button>
      </div>
    </div>
  </div>
</div></td>
    </tr>

  </tbody>
</table>
<a href="#" class="previous">&laquo; Previous</a>
				<a href="#" class="next">Next &raquo;</a>

<%@ include file="footer.jsp"%>

</body>
</html> 