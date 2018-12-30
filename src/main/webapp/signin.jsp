<html>
<head>
<title>Swarajya</title>
<%@include file="head.html"%>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 mx-auto"
				style="box-shadow: 0px 0px 5px 0px #999 !important;">
				<img src="images/swarajlogo.png" class="img-fluid" width="30%" /><h2>Sign in</h2>
				<hr />
				<form action="login" method="post">
					<fieldset>
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								type="email" name="email" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter email">
							<!-- <small id="emailHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small> -->
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" name="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password">
						</div>
						<button type="submit"  class="btn btn-primary">Login</button>
					</fieldset>
				</form>
			<hr />
			</div>
		</div>
	</div>
</body>
</html>