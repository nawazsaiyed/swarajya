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
			<div class="col-md-6 category" style="padding: 2em;"">
				<div class="form-head">
					<h2>Add Category</h2>
				</div>
				<hr />
				<form method="post" action = "addcategory">
				<fieldset>
										
					<div class="form-group">
					  <label class="form-control-label text-primary" for="inputSuccess1">Category Name:</label>
					  <input type="text" name="name" placeholder="Category Name" class="form-control " id="inputValid">
					  <!-- <div class="valid-feedback">Success! You've done it.</div> -->
					</div>
					<div class="form-group">
					
					 <label class="form-control-label text-primary" for="inputGroupFile02">Category Icon:</label>
					
						<div class="input-group mb-3">
							<div class="custom-file">
								<input type="file" class="custom-file-input"
									id="inputGroupFile02"> <label class="custom-file-label" id="imglbl"
									for="inputGroupFile02">Choose file</label>
							</div>
							<div class="input-group-append">
								<span class="input-group-text" id="">Upload</span>
							</div>
						</div>
					</div>
					
    			<button type="submit" class="btn btn-primary">Add Category</button>
				</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
	$("#inputGroupFile02").change(function(e){
		var fileName = e.target.files[0].name;
		$("#imglbl").text(fileName);
	});
});
</script>