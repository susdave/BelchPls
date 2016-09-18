<!DOCTYPE html>
<html>
<head>
	<title></title>
	
</head>
<body>
<header>
`

</header>

<?php


$servername = "localhost";
$username = "root";
$password = "";
$timestamp ="";
$dbname = "users_hackathon";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error)
{
	die("Connection failed: " . $conn->connect_error);
}

$sql = "Select Timestamp, smoke_belcher, GPS FROM hackathon ORDER BY Timestamp ASC";
$result = $conn->query($sql);

if($result->num_rows > 0)
{
    while($row = $result->fetch_assoc())
	{
		echo "<center>Timestamp: " .$row["Timestamp"]. " - Smoke Belcher: " . $row["smoke_belcher"]. " - GPS: " . $row["GPS"]. "</center><br>";
	}
}

 else 
 {
 	echo "0 results";
 }

$conn->close();
?>





</body>
</html>