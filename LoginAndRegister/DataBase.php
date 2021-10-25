<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $name, $username, $password, $email)
    {
        $name = $this->prepareData($name);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (name, username, password, email) VALUES ('" . $name . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    function fetch($table)
    {   
        $this->sql = 
            "SELECT * FROM users";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if ($result->num_rows > 0) {
            // output data of each row
            while($row = $result->fetch_assoc()) {                  
                echo "id: " . $row["id"]. " - Name: " . $row["username"]. " " . $row["password"]. "<br>";
            }
        } 
        else {
            echo "0 results";
        }
    
    }
    function book($username,$event,$zone,$booth)
    {
        $username = $this->prepareData($username);
        $event = $this->prepareData($event);
        $zone = $this->prepareData($zone);
        $booth = $this->prepareData($booth);
        $this->sql =
            "INSERT INTO Booking (username,event_id,zone_id,booth_id) VALUES ('". $username ."','". $event ."','". $zone ."','" . $booth . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    function editEmail($username , $email)
    {
        $username = $this->prepareData($username);
        $email = $this->prepareData($email);
        $this->sql =
            "UPDATE Users SET email='".$email."' WHERE username='".$username."'";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;

    }
    function fetchbooth()
    {   
        $this->sql = 
            "SELECT * FROM Picture";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if ($result->num_rows > 0) {
            // output data of each row
            while($row = $result->fetch_assoc()) {                  
                echo "event: " . $row["event_id"]. " - zone: " . $row["zone_id"]. "image:" . $row["image"]. "<br>";
            }
        } 
        else {
            echo "0 results";
        }
    
    }

}

?>
