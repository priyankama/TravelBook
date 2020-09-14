<?php
require "connection.php";
$room_type = $_POST["room_type"];
$capacity = $_POST["Capacity"];
$indate = $_POST["InDate"];
$mysql_qry = "update room set RoomType='$room_type' and Capacity='$capacity' where CheckInDate='$indate';";
if($conn->query($mysql_qry) === TRUE){
	echo "update success";
}
else{
	echo "login unsuccessful";
}
?>