<!DOCTPE html>

<html>
<head>
<title>Swarajya</title>
<%@include file="head.html"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="card mb-8  category" style="padding:3em;">
				<h2 class="text-success"><%=request.getAttribute("message") %></h2>
			</div>
		</div>	
	</div>
</body>
</html>