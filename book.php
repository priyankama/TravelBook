<?php
require "connection.php";
$roomType = $_POST["room_type"];
$cap = $_POST["capacity"];
$in = $_POST["inDate"];
$out = $_POST["outDate"];
$mysql_qry = "insert into room (RoomType,Capacity,CheckInDate,CheckOutDate) values ('$roomType','$cap','$in','$out');";
if($conn->query($mysql_qry) === TRUE{
	echo "booking success";
}
else{
	echo "booking unsuccessful";
}
?>