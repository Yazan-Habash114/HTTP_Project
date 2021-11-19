<?php

  // Authorization
  if(isset($_REQUEST['user'])&&isset($_REQUEST['pass'])) {
    $username=$_REQUEST['user'];
    $password=$_REQUEST['pass'];
    $conn = new mysqli("localhost", "root",'', "http_project");
    if ($conn->connect_error)
      die("Connection failed: " );
    else {
      $sql = "SELECT * from login";
      $result = $conn->query($sql);
      $f=0;
      if ($result->num_rows > 0) {
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
  if(isset($_FILES['uploaded_image'])) {
    if(is_uploaded_file($_FILES['uploaded_image']['tmp_name'])) {
      $sourcePath = $_FILES['uploaded_image']['tmp_name'];
      $txt=$_FILES['uploaded_image']['name'];
            
      move_uploaded_file($sourcePath,"C:/Users/HP/images/$txt");
          
      $conn = new mysqli("localhost", "root",'', "http_project");
      if ($conn->connect_error)
        die("Connection failed: " );
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
  if(isset($_REQUEST["download_image"])) {
    $url='C:\\Users\\HP\\images';
    
    $url_location=$url.'\\'.$_REQUEST["download_image"];
    
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


  // Uploading Text
  if(isset($_FILES['uploaded_file'])) {
    if(is_uploaded_file($_FILES['uploaded_file']['tmp_name'])){
      $sourcePath = $_FILES['uploaded_file']['tmp_name'];
      $txt=$_FILES['uploaded_file']['name'];
          
      move_uploaded_file($sourcePath,"C:/Users/HP/text_file/$txt");
          
        
      $conn = new mysqli("localhost", "root",'', "http_project");
      if ($conn->connect_error)
        die("Connection failed: " );
      else {
        $sql = "INSERT INTO  text_file (name,url) VALUES ('$txt','$sourcePath')";
        if ($conn->query($sql) === TRUE) {
          echo "New record created successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $conn->close();
      }
    }
  }

  // Downloading Text
  if(isset($_REQUEST['download_text'])) {
    $url='C:/Users/HP/text_file';

    $url_location=$url.'/'.$_REQUEST["download_text"];
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


  // Downloading PDF
  if(isset($_REQUEST["download_pdf"])) {
    $url='C:/Users/HP/pdf';
    $url_location=$url.'/'.$_REQUEST["download_pdf"];
      
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

  // Upload PDF
  if(isset($_FILES['uploaded_pdf'])) {
    if(is_uploaded_file($_FILES['uploaded_pdf']['tmp_name'])){
      $sourcePath = $_FILES['uploaded_pdf']['tmp_name'];
      $txt=$_FILES['uploaded_pdf']['name'];
            
      move_uploaded_file($sourcePath,"C:/Users/HP/pdf/$txt");
      
      $conn = new mysqli("localhost", "root",'', "http_project");
      if ($conn->connect_error)
        die("Connection failed: " );
      else {
        $sql = "INSERT INTO  pdf (name,url) VALUES ('$txt','$sourcePath')";
        if ($conn->query($sql) === TRUE) {
          echo "New record created successfully";
        } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $conn->close();
      }
    }
  }

?>