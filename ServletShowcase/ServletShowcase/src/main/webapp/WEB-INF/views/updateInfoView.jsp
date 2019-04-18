<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Product</title>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   </head>
   <body>
 
      <jsp:include page="_headerEmp.jsp"></jsp:include>
   
 
      <h3>Update Info Page</h3>
 
      <p style="color: red;">${errorString}</p>
 
     
         <form method="POST" action="${pageContext.request.contextPath}/update">
            <input type="hidden" name="username" value="${loginedUser.userName}"/>
            <table border="1"class="table table-dark table-striped">
             	<tr>
               	
                  <th>Input your the information you want to change</th>
              		<td></td>
               </tr>
               <tr>
               	
                  <td>New Address</td>
                  <td><input type="text" name="address"/></td>
               </tr>
               <tr>
                  <td>New Email</td>
                  <td><input type="text" name="email" /></td>
               </tr>
               <tr>
                  <td>New Password</td>
                  <td><input type="text" name="password" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                     
                  </td>
               </tr>
            </table>
         </form>

 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html> 

