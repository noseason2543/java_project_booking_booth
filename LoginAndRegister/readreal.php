<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','LoginAndRegister');

 
$con = mysqli_connect(HOST,USER,PASS,DB);
if (isset($_GET['id'])) {
    $id = $_GET['id'];
} else {
    $id = '';
}
 
$sql = "select * from users where id like '%$id%'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,array('username'=>$row[1]

));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>