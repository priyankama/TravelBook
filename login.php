<?php
require "connection.php";
$user_email = $_POST["user_name"];
$user_password = $_POST["password"];
$mysql_qry = "select * from visitorlogin where Email like '$user_email' and Password like '$user_password';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result)>0){
	echo "login success";
}
else{
	echo "login unsuccessful";
}
?>