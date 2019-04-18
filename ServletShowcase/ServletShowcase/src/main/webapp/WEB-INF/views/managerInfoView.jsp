<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Manager Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 </head>
 <body>
 	<div>
    <jsp:include page="_header.jsp"></jsp:include>
    </div>
  
 	  <nav class="navbar navbar-expand-sm bg-light">

  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="managerInfo">Account</a>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="request">Request</a>
    </li>
     <li class="nav-item">
     <a class="nav-link" href="logout">Log Out</a>
    </li>
  </ul>
</nav>
    <div class="container">  
    <h1> Manager Page</h1>
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Address</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${user.firstname }</td>
        <td>${user.lastname }</td>
        <td>${user.email }</td>
        <td>${user.gender }</td>
        <td>${user.address }</td>
      </tr>
    </tbody>
  </table>
</div>
<div class="container">  
 <h1> Total employee</h1>
  <table class="table table-dark table-striped">
  <thead>
       <tr>
       	  <th>Username</th>
          <th>Password</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Gender</th>
           <th>Address</th>
          <th>Email</th>
        
       </tr>
        </thead> 
        <tbody>
       <c:forEach items="${userAccountList}" var="userAccount" >
          <tr>
			<td>${userAccount.userName }</td>
             <td>${userAccount.password }</td>
             <td>${userAccount.firstname }</td>
             <td>${userAccount.lastname }</td>
             <td>${userAccount.gender }</td>
             <td>${userAccount.address }</td>
             <td>${userAccount.email }</td>
          </tr>
       </c:forEach>
       </tbody>
    </table>
 </div>

 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>