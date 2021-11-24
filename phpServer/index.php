<?php

  $host = 'localhost';
  $root = 'root';
  $pass_word = '';
  $db = 'http_project';

  // Authorization
  if(isset($_REQUEST['user']) && isset($_REQUEST['pass'])) {
    $username = $_REQUEST['user'];
    $password = $_REQUEST['pass'];
    
    $conn = new mysqli($host, $root, $pass_word, $db);
    if ($conn->connect_error)
      die("Connection to DB is failed!");
    else {
      $sql = "SELECT * from login";
      $result = $conn->query($sql);
      $f = 0;
      if($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc())
          if($username==$row['username']&&$password==$row['password'])
            $f=1;
        echo $f;
      }
      $conn->close(); 
    }
  }


  // Uploading Image
  if(isset($_FILES['UploadImage'])) {
    if(is_uploaded_file($_FILES['UploadImage']['tmp_name'])) {
      $sourcePath = $_FILES['UploadImage']['tmp_name'];
      $txt=$_FILES['UploadImage']['name'];
            
      move_uploaded_file($sourcePath,"C:/Users/HP/images/$txt");
          
      $conn = new mysqli($host, $root, $pass_word, $db);
      if ($conn->connect_error)
        die("Connection to DB is failed!");
      else {
        $sql = "INSERT INTO  image (name,image_dir) VALUES ('$txt','$sourcePath')";
        if ($conn->query($sql) === TRUE) {
          echo "New record created successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $conn->close();
      }
    }
  }

  // Download Image
  if(isset($_REQUEST["DownloadImage"])) {
    $url='C:\\Users\\HP\\images';
    
    $url_location=$url.'\\'.$_REQUEST["DownloadImage"];
    
    $file = $url_location;
    $handle = fopen($url_location, 'rb');
    if (file_exists($file)) {
      header('Content-Description: File Transfer');
      header('Content-Type:application/octet-stream;charset=UTF-8');
      header('Content-Disposition: attachment; filename="'.basename($file).'"');
      header('Expires: 0');
      header('Cache-Control: must-revalidate');
      header('Pragma: public');
      header('Content-Length: ' . filesize($file));
      readfile($file);
      fclose($handle);
    }
  }
?>