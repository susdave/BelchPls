<!DOCTYPE >
<html>
<head>
	<title></title>
</head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-3.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSXAOugUemP6_eSQy_FzHM3Dm3k1ihWek"></script>

<body>



<div id="map" style="height: 768px; width: 1368px;">
<!-- <iframe id="google_map" width="1500" height="800" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.uk?ouput=embed">
	</iframe> -->
</div>

<script>
	var map;
	var oMapDiv = document.getElementById('map');
	var oLocation = {
		lat: 0,
		lng: 0
	};
	var aMarker = [];

	var _oData;

	console.log('Script loaded');
	// console.log($('#collect').value);

	map = new google.maps.Map(oMapDiv, {
		center: oLocation,
		zoom: 17
	});

	setInterval(function() {
		$.get('getCollect.php', function(data) {
			_oData = JSON.parse(data);
			a(_oData);
		});
	}, 3000);

	var getCurrent = function()
	{
		navigator.geolocation.getCurrentPosition(a, b);
		return false;
	}
	var x = document.getElementById("oLocation.lat")
	var a = function(pos)
	{
		console.log(pos);
		console.log('To load map');
		oLocation.lat = parseFloat(pos.Latitude);
		oLocation.lng = parseFloat(pos.Longtitude);

		map.setCenter(oLocation);

		aMarker[0] = createMarker(oLocation);
		aMarker[0].addListener('click', function() {
			var _infowindow = createInfoWindow('x.');
		    _infowindow.open(map, aMarker[0]);
	  	});
	} 

	var createMarker = function(oLocation) {
		var _marker = new google.maps.Marker({
			position: oLocation,
			map: map
		});
		return _marker;
	}

	var createInfoWindow = function(sText = 'Hello World!') {
		var _infowindow = new google.maps.InfoWindow({
			content: sText
		});
		return _infowindow;
	}

	var b = function(error)
	{
	  if (error.code === 1)
	  {
	  	alert('Unable to get location');
	  }
	}

	// document.getElementById('get_location').onclick = function()
	// {
	// 	navigator.geolocation.getCurrentPosition(a, b);
	// 	return false;
	// }
	
</script>

</body>
</html>