
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>

<form action="hack4.php" method="post">
Longitude:<input type="text" name="Longtitude"><br>
Latitude: <input type="text" name="Latitude"><br>
Status: <input type="text" name="Status"></br>
PlateNum:<input type="text" name="PlateNum">
<input type="submit">
</form>


 
</body>
</html>



<?php
   

   $dbhost = "localhost";
   $dbuser = "root";
   $dbpass = "";
   

   $conn = mysql_connect($dbhost, $dbuser, $dbpass);
   
   if(! $conn ) {
      die('Could not connect: ' . mysql_error());
   }

  
   $longitude = $_POST["Longtitude"];
   $latitude = $_POST["Latitude"];
   $status = $_POST["Status"];
   $plate = $_POST["PlateNum"];
   
   $sql = "INSERT INTO collect (Longtitude, Latitude, Status, PlateNum) VALUES ( '$longitude', '$latitude',  '$status',  '$plate'    )";
      
   mysql_select_db('trial');
   $retval = mysql_query( $sql, $conn );
   
   if(! $retval ) {
      die('Could not enter data: ' . mysql_error());
   }
   
   else{
   	 echo "Entered data successfully\n";
   }
   
   
   mysql_close($conn);
?>