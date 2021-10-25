<?php
require "DataBase.php";
$db = new DataBase();
if ($db->dbConnect())
{
    echo "success";
}
else{
    echo "fail";
}
?>