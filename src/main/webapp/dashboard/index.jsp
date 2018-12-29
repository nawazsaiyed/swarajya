<!DOCTPE html>
<%
if(session.getAttribute("loginUser") == null)
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
	<div class="row justify-content-md-center" style="margin-top:4em !important">
		<div class="card mb-3 category">
			<a href="categories.jsp">
			  <h3 class="card-header">Categories</h3>
			  <img style="height: 200px; width: 100%; display: block;" src="../images/category.png" alt="Farm Production">
			</a>
		</div>
		
		<div class="card mb-3 category">
			<a href="users.jsp">
			  <h3 class="card-header">Users</h3>
			  <img style="height: 200px; width: 100%; display: block;" src="../images/userlogo.png"  alt="Farm Production">
			 </a>
		</div>
		<div class="card mb-3 category">
			<a href="ngo.jsp">
			  <h3 class="card-header">NGO</h3>
			  <img style="height: 200px; width: 100%; display: block;" src="../images/ngologo.png" alt="Farm Production">
			 </a>
		</div>
		
		<div class="card mb-3 category">
			<a href="settings.jsp">
			  <h3 class="card-header">Other</h3>
			  <img style="height: 200px; width: 100%; display: block;" src="../images/settings.png" alt="Farm Production">
			 </a>
		</div>
	</div>
</div>
</body>
</html>