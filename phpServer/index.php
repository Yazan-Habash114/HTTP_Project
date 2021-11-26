<?php

  $host = 'localhost';
  $root = 'root';
  $pass_word = '';
  $db = 'http_project';


  // Delete an image
  if(isset($_REQUEST['imageName'])) {
     $img_name = $_REQUEST['imageName'];
     $connection = new mysqli($host, $root, $pass_word, $db);
     if($connection->connect_error)
	die('Connection to DB is failed!');
     else {
	$sql_query = "DELETE FROM `images` WHERE `name` = '$img_name'";
	$result = $connection->query($sql_query);
	$connection->close();
     }
  }


  // Upload Description
  if(isset($_REQUEST['desc']) && isset($_REQUEST['imgName'])) {
     $desc = $_REQUEST['desc'];
     $name = $_REQUEST['imgName'];

     $connection = new mysqli($host, $root, $pass_word, $db);
     if ($connection->connect_error)
      die("Connection to DB is failed!");
     else {
       $sql = "UPDATE `images` SET `description` = '$desc' WHERE `name` = '$name'";
       $result = $connection->query($sql);
       $connection->close(); 
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
        $sql = "INSERT INTO  images (name, image_dir) VALUES ('$txt', '$sourcePath')";
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