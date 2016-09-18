<!DOCTYPE>
<html>
<head>
	<title>Location</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-3.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSXAOugUemP6_eSQy_FzHM3Dm3k1ihWek"></script>
</head>

<style>
	
body
{
	background: url('world-political-map-large-size.jpg');
	background-repeat: no-repeat;
}


</style>


<body>

<div class=""><button class="btn btn-lg btn-primary btn-block" id="get_location" type="submit" name="login" value="Login" style="background-color:#25383C; color:#EBF4FA;">My Current Location</button>
</div>




<div id="map" style="height: 1000px; width: 1000px;">
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

var a = function(pos)
{
	oLocation.lat = pos.coords.latitude;
	oLocation.lng = pos.coords.longitude;
	console.log(oLocation);
	   // acc = pos.coords.accuracy,
	   // coords = lat + ',' + long;
	// document.getElementById('google_map').setAttribute('src','https://maps.google.co.uk/?q='+ coords +' &z=60&output=embed');
	map = new google.maps.Map(oMapDiv, {
		center: oLocation,
		zoom: 17
	});

	aMarker[0] = createMarker(oLocation);
	aMarker[0].addListener('click', function() {
		var _infowindow = createInfoWindow('This is PLDT')
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

// marker = new google.maps.Marker({
//              position: latlng,
//              map: map                    
// }); //end marker

// //Add listener
// google.maps.event.addListener(marker, "click", function (event) {
//                     alert(this.position);
// }); //end addListener

var b = function(error)
{
  if (error.code === 1)
  {
  	alert('Unable to get location');
  }
}



document.getElementById('get_location').onclick = function()
{
	navigator.geolocation.getCurrentPosition(a, b);
	return false;
}


</script>



</body>
</html>