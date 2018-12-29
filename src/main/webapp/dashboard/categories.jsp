<!DOCTPE html>
<%
	if (session.getAttribute("loginUser") == null)
		response.sendRedirect("login.jsp");
%>
<html>
<head>
<title>Swarajya</title>
<%@include file="head.html"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row justify-content-md-center"
			style="margin-top: 4em !important">
		<div class="col-md-10 category" style=padding:2em;">
			<div class="table-head">
				<h2 style="float:left">Categories</h2>
				<button class="btn btn-primary" style="float:right" id="add">Add Category</button>
			
			</div>
				<table  class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Categoty Name</th>
							<th>View</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>1</th>
							<td>Farm Production</td>
							<td><a href="sub-category.jsp">View Sub Categories</a></td>
							<td>
								<a href="edit-category.jsp">Edit</a>
								<a href="delete-category.jsp">Delete</a>
							</td>
						</tr>
						<tr>
							<th>2</th>
							<td>Dairy Products</td>
							<td><a href="sub-category.jsp">View Sub Categories</a></td>
							<td>
								<a href="edit-category.jsp">Edit</a>
								<a href="delete-category.jsp">Delete</a>
							</td>
						</tr>
						<tr>
							<th>2</th>
							<td>Dairy Products</td>
							<td><a href="sub-category.jsp">View Sub Categories</a></td>
							<td>
								<a href="edit-category.jsp">Edit</a>
								<a href="delete-category.jsp">Delete</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function()
{
	$("#add").click(function(){
		window.location.assign("add-category.jsp");
	});
});
</script>