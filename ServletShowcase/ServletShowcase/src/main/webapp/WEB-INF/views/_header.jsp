<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
     <body>
<div style="background: pink; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Welcome </h1>
  </div>
 
  <div style="float: right; padding: 5px; text-align: right;">
     <!-- User login name display -->
     Hello <b>${loginedUser.lastname}</b>.
     Have a beautiful day! 

   
     
    

     
  </div>
 
</div>
 </body>
</html>