<%@page import="com.bean.Teachers"%>
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
	
	<!-- Display teachers -->
	<h1>Teachers table</h1>
	
	
	<div class="container">
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Birth number</th>
			<th>Email</th>
			<th>Phone number</th>
			<th>Edit</th>
			<th>Delete</th>
		
		</tr>
	<c:forEach var="tchr" items="${requestScope.teacherList  }"> 
	
			<tr>
				
				<td>${tchr.tid}</td>
				<td>${tchr.name}</td>
				<td>${tchr.surname}</td>
				<td>${tchr.brthno}</td>
				<td>${tch.phone}</td>
				<td>${tch.email}</td>
			
				<td><a href="edit?email=${tch.tid }">Edit</a> </td>
				<td><a href="delete?email=${tch.tid }">Delete</a> </td>
			</tr>
		
	
	</c:forEach>
		
	
	</table>
	</div>
	
	<!-- Adding teachers -->
	<div class="container">
		<h5>Register a new Teacher</h5>
	</div>
	<div class="container">	
		<%
		String error = (String) request.getAttribute("error");
		if(error !=  null){%>
		<div class="error"><%= error %></div>
		<%} %>
		<form action="teachers" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					

					<div class="form-group">
						<label for="brthno">Birth number: </label> <input type="text"
							class="form-control" id="brthno" placeholder="Enter Birth number" name="brthno">
					</div>
					
					<div class="form-group">
						<label for="email">Email: </label> <input type="text"
							class="form-control" id="email" placeholder="Enter Email" name="email">
					</div>

					<div class="form-group">
						<label for="name">Teacher's Name: </label> <input type="text"
							class="form-control" id="name" placeholder="Enter First Name" name="name">
					</div>

					<div class="form-group">
						<label for="phone">Phone number: </label> <input type="text"
							class="form-control" id="phone" placeholder="Enter Phone number" name="phone">
					</div>


					<div class="form-group">
						<label for="surname">Teachers's Surname: </label> <input type="text"
							class="form-control" id="Surname" placeholder="Enter Surname" name="sur">
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