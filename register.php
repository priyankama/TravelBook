<?php
require "connection.php";
$user_name = $_POST["user_name"];
$user_email = $_POST["user_email"];
$user_password = $_POST["password"];
$user_mobile = $_POST["user_mobile"];
$mysql_qry = "insert into visitorlogin (Name,Email,Password,Mobile) values ('$user_name','$user_email','$user_password','$user_mobile');";
if($conn->query($mysql_qry) === TRUE{
	echo "insert success";
}
else{
	echo "login unsuccessful";
}
?>