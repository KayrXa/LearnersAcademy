<%@page import="com.bean.Classes"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
p {
	color: white;
	background-color: black;
	padding: 10px;
}
</style>


</head>
<body>
	
	<%@ include file="header.jsp"%>
	
	
	
	<h1>Classes table</h1>
	
	
	<div class="container">
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Subject name</th>
			<th>Subject shortcut</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	<c:forEach var="cls" items="${requestScope.classList}"> 
		
			<tr>
				<td>${ cls.cid}</td>
				<td>${ cls.name}</td>
				
				<td><a href="edit?email=${ cls.name}">Edit</a> </td>
				<td><a href="delete?email=${ cls.name}">Delete</a> </td>
			</tr>
	
	
	</c:forEach>
		
		
		
		
		
		
	</table>
	</div>
	
	<div class="container">
		<h5>Register a new Class</h5>
	</div>
	<div class="container">	
		<%
		String error = (String) request.getAttribute("error");
		if(error !=  null){%>
		<div class="error"><%= error %></div>
		<%} %>
		<form action="classes" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="name">Class Name: </label> <input type="text"
							class="form-control" id="name" placeholder="Enter Class Name" name="name">
					</div>
						
					
					<div>
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>