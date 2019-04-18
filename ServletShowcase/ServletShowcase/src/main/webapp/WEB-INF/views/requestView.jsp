<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Request List</title>
   <link rel="stylesheet" type="text/css" href="C:\Users\Phuc\Downloads\ServletShowcase\ServletShowcase\src\main\webapp\WEB-INF\views\Style.css"> 
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>

    .searchbar{
    margin-bottom: auto;
    margin-top: auto;
    height: 60px;
    background-color: #353b48;
    border-radius: 30px;
    padding: 10px;
    }

    .search_input{
    color: white;
    border: 0;
    outline: 0;
    background: none;
    width: 0;
    caret-color:transparent;
    line-height: 40px;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_input{
    padding: 0 10px;
    width: 450px;
    caret-color:red;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_icon{
    background: white;
    color: #e74c3c;
    }

    .search_icon{
    height: 40px;
    width: 40px;
    float: right;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    color:white;
    }
</style>
 </head>
 <body>
 		<div>
 		<jsp:include page="_header.jsp"></jsp:include></div>
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
    <h3>Request List</h3>
    	  <p style="color: red;">${errorString}</p>
          <div class="container h-100">
      <div class="d-flex justify-content-center h-100">
        <div class="searchbar">
           <input class="search_input" type="text" id="myInput" onkeyup="myFunction()" name="" placeholder="Search...">
          <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
        </div>
      </div>
    </div>
 	
         <br>
       
 

          <table border="1" id="myTable" class="table table-dark table-striped">
       <tr class="header">
       	  
          <th>Name</th>
          <th>RequestReason</th>
          <th>Price</th>
          <th>RequestId</th>
          <th>Approval</th>
          <th>By Manager</th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
           <td>${product.name}</td>
			<td>${product.code }</td>
             <td>${product.price}</td>
             <td>${product.requestid}</td>
              <td>${product.approval}</td>
              <td>${product.managername}</td>
          </tr>
       </c:forEach>
    </table>

         <a href="approval" class="btn btn-warning" role="button">Approval Request</a> 
  
    
  

 
    <jsp:include page="_footer.jsp"></jsp:include>
 <script>
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
 </body>
</html>