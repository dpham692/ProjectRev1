<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 </head>
 <body>
 	<div>
    <jsp:include page="_headerEmp.jsp"></jsp:include>
	
      </div>
  
 
    <div class="container">  
    <h1> Employee Page</h1>
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Address</th>
        <th>ID</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${user.firstname }</td>
        <td>${user.lastname }</td>
        <td>${user.email }</td>
        <td>${user.gender }</td>
        <td>${user.address }</td>
        <td>${user.id }</td>
      </tr>
    </tbody>
  </table>
</div>
 
 

 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>