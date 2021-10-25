<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','LoginAndRegister');

 
$con = mysqli_connect(HOST,USER,PASS,DB);
if (isset($_GET['event']) && isset($_GET['zone']) && isset($_GET['boothtype'])) {
    $event = $_GET['event'];
    $zone = $_GET['zone'];
    $boothtype = $_GET['boothtype'];
} else {
    $event ='';
    $zone = '';
    $boothtype = '';
}
 
$sql = "select * from Picture where event_id = '$event' and zone_id = '$zone' and booth_type = '$boothtype'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push(
    $result,array('image'=>$row[4]
    
    )


);
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>