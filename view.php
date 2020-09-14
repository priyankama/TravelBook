<?php 
 
	require "connection.php";
	
	//creating a query
	$stmt = $conn->prepare("SELECT RoomNo,RoomType,Capacity,CheckInDate,CheckOutDate FROM room;");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($RoomNo, $RoomType, $Capacity, $CheckInDate, $CheckOutDate );
	
	$rooms = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['id'] = $RoomNo; 
		$temp['type'] = $RoomType; 
		$temp['capacity'] = $Capacity; 
		$temp['indate'] = $CheckInDate; 
		$temp['outdate'] = $CheckOutDate; 
		array_push($rooms, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($rooms);
?>