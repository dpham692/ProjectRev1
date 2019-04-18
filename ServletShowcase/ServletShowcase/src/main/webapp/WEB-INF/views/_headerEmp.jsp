<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div style="background: pink; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Welcome </h1>
  </div>
 
  <div style="float: right; padding: 5px; text-align: right;">
     <!-- User login name display -->
     Hello <b>${loginedUser.lastname}</b>.
     Have a beautiful day! 
     <a class="nav-link" href="${pageContext.request.contextPath}/userInfo">Account</a>
     <a class="nav-link" href="${pageContext.request.contextPath}/requestEmployee">Request</a>
      <a class="nav-link" href="${pageContext.request.contextPath}/update">Update Info</a>
     <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log Out</a>
     
  </div>
 
</div>