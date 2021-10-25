<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email'])) {
    if ($db->dbConnect()) {
        if ($db->editEmail($_POST['username'], $_POST['email'])) {
            echo "Edit Success";
        } else echo "Edit Fail";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>