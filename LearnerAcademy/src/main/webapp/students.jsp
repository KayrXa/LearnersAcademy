<%@page import="com.bean.Students"%>
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
	<h1>Students table</h1>


<!-- Actual student list -->
	<div class="container">
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Birth number</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Edit</th>
				<th>Delete</th>
			
			</tr>
		<c:forEach var="student" items="${request.Scope.students}"> 
			<tr>
					
					<td>${student.name}</td>
					<td>${student.sur}</td>
					<td>${student.brthno}</td>
					<td>${student.phone}</td>
					<td>${student.semail}</td>
							
					<td><a href="edit?email=${student.brthno }">Edit</a> </td>
					<td><a href="delete?email=${student.brthno }">Delete</a> </td>
				</tr>
		
		
		</c:forEach>
		</table>
	</div>	
			
<!-- Adding new student -->			
	<div class="container">
		<h5>Register a new student</h5>
	</div>
	<div class="container">	
		<%
		String error = (String) request.getAttribute("error");
		if(error !=  null){%>
		<div class="error"><%= error %></div>
		<%} %>
		<form action="students" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="name">Student's First Name: </label> <input type="text"
							class="form-control" id="name" placeholder="Enter First Name" name="name">
					</div>

					<div class="form-group">
						<label for="sur">Student's Last Name: </label> <input type="text"
							class="form-control" id="sur" placeholder="Enter Surname" name="sur">
					</div>
					<div class="form-group">
						<label for="cid">Class ID: </label> <input type="text"
							class="form-control" id="cid" placeholder="Enter Class ID" name="cid">
					</div>
					<div class="form-group">
						<label for="brthno">Birth number: </label> <input type="text"
							class="form-control" id="brthno" placeholder="Enter Birth number" name="brthno">
					</div>
					<div class="form-group">
						<label for="phone">Phone number: </label> <input type="text"
							class="form-control" id="phone" placeholder="Enter Phone number" name="phone">
					</div>
					<div class="form-group">
						<label for="email">Email: </label> <input type="text"
							class="form-control" id="email" placeholder="Enter Class email" name="email">
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