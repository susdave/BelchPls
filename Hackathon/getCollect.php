<?php

$servername = "localhost";
$username = "root";
$password = "";
$timestamp ="";
$dbname = "trial";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error)
{
	die("Connection failed: " . $conn->connect_error);
}

$sql = "Select Timestamp, Longtitude, Latitude, Status, PlateNum FROM collect ORDER BY Timestamp Desc limit 1";
$resultCollect = $conn->query($sql);

if ($resultCollect->num_rows > 0) {
    // output data of each row
    while($row = $resultCollect->fetch_assoc()) {
        echo json_encode($row);
    }
} else {
    echo "0 results";
}

$conn->close();

?>