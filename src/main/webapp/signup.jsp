<html>
<head>
<title>Swarajya</title>
<%@include file="head.html"%>
</head>
<body onload="getLocation()">
	<%@include file="header.jsp"%>
	<div class="container-fluid">
		<div class="row" style="margin-top: 4em !important">
			<div class="col-md-6 category" style="padding: 2em; float: left">
				<div class="form-head">
					<h2>Sign up</h2>
				</div>
				<hr />
				<form method="post" action="signup" enctype="multipart/form-data">
					<input type="hidden" id="lat" name="lattitude" />
					<input type="hidden" id="long" name="longitude" />
					<fieldset>
						<div class="form-group">
							<label class="form-control-label text-primary"
								for="inputSuccess1">Select User Type:</label> 
								<select
								name="utype" class="custom-select" id="utype">
								<option value="2" selected>NGO</option>
								<option value="1" >Farmer</option>
							</select>
						</div>
						<div class="form-row">

							<div class="form-group col-md-6" id="fullName">
								<label class="form-control-label text-primary"
									for="inputSuccess1">Full Name:</label> <input type="text"
									name="name" placeholder="Enter Full Name" class="form-control "
									>
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>

							<div class="form-group col-md-6"  id="contactPerson">
								<label class="form-control-label text-primary"
									for="inputSuccess1">Contact Person:</label> <input type="text"
									name="contactPerson" placeholder="Enter Full Name"
									class="form-control ">
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>

						</div>
						<div class="form-row">

							<div class="form-group col-md-6">
								<label class="form-control-label text-primary"
									for="inputSuccess1">Contact Number:</label> <input type="text"
									name="contact" placeholder="Enter Number" class="form-control "
									id="inputValid">
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>
							<div class="form-group col-md-6">
								<label class="form-control-label text-primary"
									for="inputSuccess1">E-mail:</label> <input type="email"
									name="email" placeholder="Enter E-mail" class="form-control "
									id="inputValid">
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>

						</div>
						<div class="form-group">

							<label class="form-control-label text-primary"
								for="inputGroupFile02">Profile Photo:</label>

							<div class="input-group mb-3">
								<div class="custom-file">
									<input type="file" class="custom-file-input" name="uploadFile"
										id="inputGroupFile02"> <label
										class="custom-file-label" id="imglbl" for="inputGroupFile02">Choose
										file</label>
								</div>
								<div class="input-group-append">
									<span class="input-group-text" id="">Upload</span>
								</div>
							</div>
						</div>

						<div class="form-row">

							<div class="form-group col-md-6">
								<label class="form-control-label text-primary"
									for="inputSuccess1">Password:</label> <input type="password"
									name="password" placeholder="Enter Password"
									class="form-control " id="inputValid">
									<input
									type="password" name="cpassword"
									placeholder="Enter Confirm Password" style="margin-top:25px" class="form-control "
									id="inputValid">
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>
							<div class="form-group col-md-6">
								<label class="form-control-label text-primary"
									for="inputSuccess1">Address:</label> 
									<textarea rows="3" cols="30" name="address" placeholder="Enter Address" class="form-control"></textarea>
								<!-- <div class="valid-feedback">Success! You've done it.</div> -->
							</div>

						</div>
						<button type="submit" class="btn btn-primary">Sign up</button>
					</fieldset>
				</form>
			</div>
			<div class="col-md-4 category" style="padding: 2em; float: left">
				<h2>Select Your Location</h2>

				<div id="map"></div>
			</div>
		</div>
	</div>
	<script>
		// Note: This example requires that you consent to location sharing when
		// prompted by your browser. If you see the error "The Geolocation service
		// failed.", it means you probably did not give permission for the browser to
		// locate you.
		var map, infoWindow;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 23.045063799999998,
					lng : 72.5663757
				},
				zoom : 16
			});
			infoWindow = new google.maps.InfoWindow;

			// Try HTML5 geolocation.
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var pos = {
						lat : position.coords.latitude,
						lng : position.coords.longitude
					};

					infoWindow.setPosition(pos);
					infoWindow.setContent('Location found.');
					infoWindow.open(map);
					map.setCenter(pos);
				}, function() {
					handleLocationError(true, infoWindow, map.getCenter());
				});
			} else {
				// Browser doesn't support Geolocation
				handleLocationError(false, infoWindow, map.getCenter());
			}
		}

		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow
					.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
							: 'Error: Your browser doesn\'t support geolocation.');
			infoWindow.open(map);
		}
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2EsD9iq-5J3NPevxKQWA0soIQiQOsR-o&callback=initMap&callback=initMap">
		
	</script>
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
<script>
var x = document.getElementById("demo");

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else { 
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) {
  $("#lat").val(position.coords.latitude);
  $("#long").val(position.coords.longitude);
}
</script>
<script type="text/javascript">
$(document).ready(function()
{
	$("#utype").change(function()
	{
		if($(this).val() == 1)
		{
			$("#contactPerson").hide();
			$("#firstName").removeClass("col-md-6");
			$("#firstName").addClass("col-md-12");
		}
		else
		{
			$("#contactPerson").show();
			$("#firstName").removeClass("col-md-12");
			$("#firstName").addClass("col-md-6");
		}
	})
});
</script>