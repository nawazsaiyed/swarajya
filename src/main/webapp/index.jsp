<html>
<head>
	<title>Swarajya</title>
	<%@include file="head.html" %>
</head>
<body>
<%@include file="header.html" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 mx-auto">
			<img src="images/swarajlogo.png" class="img-fluid" style="width: 100%" />
		</div>
	</div>
	<div class="row">
		
		<div class="col-md-4 mx-auto" >
			<form method="get" action="search-result.jsp" class="form-inline">
				<div class="form-group">
			      	<input type="search" class="form-control form-control-md"  placeholder="Enter Search text">
			    	<button type="submit" class="btn btn-primary" style="margin-left:10px;">Search</button>
			    </div>
			</form>
		</div>
	</div>
	<div class="container">	
	<div class="row">
		<div class="card mb-3 category">
		  <h3 class="card-header">Farm Production</h3>
		  <img style="height: 200px; width: 100%; display: block;" src="images/icons/category1.png" alt="Farm Production">
		</div>
		
		<div class="card mb-3 category">
		  <h3 class="card-header">Services</h3>
		  <img style="height: 200px; width: 100%; display: block;" src="images/icons/category2.png" alt="Farm Production">
		</div>
		<div class="card mb-3 category">
		  <h3 class="card-header">Dairy Products</h3>
		  <img style="height: 200px; width: 100%; display: block;" src="images/icons/category3.png" alt="Farm Production">
		</div>
		
		
	</div>
</div>
</body>
</html>
