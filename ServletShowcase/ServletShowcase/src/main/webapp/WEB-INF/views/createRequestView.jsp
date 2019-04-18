<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Request Page</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   </head>
   <body>
    
  
   
       
      <h3>Create Request</h3>
       
      <div>
       <p style="color: red;">${errorString}</p>
      <form method="POST" action="${pageContext.request.contextPath}/createRequest">
      	
         <table border="1" class="table table-dark table-striped">
         	<tr>
               <td>Request Reason</td>
               <td><input type="text" name="code" value="${product.code}" /></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="text" name="price" value="${product.price}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="userInfo">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       </div>
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>