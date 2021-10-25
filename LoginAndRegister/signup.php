<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['password']) && isset($_POST['name']) && isset($_POST['email']) ) {
    if ($db->dbConnect()) {
        if ($db->signUp("Users", $_POST['name'], $_POST['username'], $_POST['password'], $_POST['email'])) {
            echo "Sign Up Success";
        } else echo "Sign up Fail";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
