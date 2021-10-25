<?php
require "DataBase.php";
$db = new DataBase();
if ($db->dbConnect()) {
    if ($db->fetch("users")) {
        echo "Read Success";
    } else echo "Read Fail";
} else echo "Error: Database connection";
?>