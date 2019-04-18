<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Approval Request Page</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   </head>
   <body>
    
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
   
       
      <h3>Approval Request</h3>
       
      <div>
       <p style="color: red;">${errorString}</p>
      <form method="POST" action="${pageContext.request.contextPath}/approval">
      	
         <table border="1" class="table table-dark table-striped">
         	<tr>
               <td>Request ID</td>
               <td><input type="text" name="requestid"/></td>
            </tr>
            <tr>
               <td>Approval</td>
               <td><input type="text" name="approval"/></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="request">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       </div>
     
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>