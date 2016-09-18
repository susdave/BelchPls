<html>
<body>

Login As:
<ul class="nav nav-tabs">
  <li class="active">User	</li>
  <li>Admin</li>
 
</ul>
<?php
	//Connection file
	$servername = "localhost";
	$username = "root";
	$password = "";
	$database = "accounts";

	// Create connection
	$conn = mysqli_connect($servername, $username, $password, $database);

	// Check connection
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	
		if(isset($_POST['username'])){
			$username = $_POST['username'];
			$password = $_POST['password'];
			
			$sql = "SELECT password FROM admin_acc WHERE username LIKE '".$username."';";
			
			$result = $conn->query($sql);
			$num = mysqli_num_rows($result);
			if ($result->num_rows > 0) {
				while($row = $result->fetch_assoc()) {
					if ($row['password'] == $password){
						header("Location: http://9gag.com");
					}else{
						$error = "username or password is incorrect.";
					}
				}
			}else{
				
			}
			
		}






?>
	  <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
		<div class="form-group">
		  <label for="username">Username:</label>
		  <input type="text" class="form-control" name="username" placeholder="Enter Username">
		</div>
		<div class="form-group">
		  <label for="pwd">Password:</label>
		  <input type="password" class="form-control" name="password" placeholder="Enter password">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	  </form>





</body>

</html>

