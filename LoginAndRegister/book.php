<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['event_id']) && isset($_POST['zone_id']) &&isset($_POST['booth_id'])&&isset($_POST['booking_time'])) {
    if ($db->dbConnect()) {
        if ($db->book($_POST['username'],$_POST['event_id'],$_POST['zone_id'],$_POST['booth_id'],$_POST['booking_time'])) {
            echo "Book Success";
        } else echo "Book Fail";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>