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
	
	
	<!-- Actual relations -->
	
	<h1>Relation table</h1>
	
	
	<div class="container">
	<table class="table">
		<tr>
			<th>Class name</th>
			<th>Teacher name</th>
			<th>Subject name</th>
			<th>Edit</th>
			<th>Delete</th>
					</tr>
	<c:forEach var="classes" items="${request.Scope.classes }"> 
	
				<tr>
				
				<td>${classes.name}</td>
				<td>${teachers.name}</td>
				<td>${subjects.name}</td>
				<td><a href="edit?email=${classes.name }">Edit</a> </td>
				<td><a href="delete?email=${classes.brthno }">Delete</a> </td>
			</tr>
	
	</c:forEach>
		
		
	</table>
	</div>
	
	
	<!-- Creating new relation -->
	<div class="container">
		<h5>Set a new relations</h5>
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
						<label for="cid">Class Name: </label> <input type="text"
							class="form-control" id="cid" placeholder="Enter Class Name" name="cid">
					</div>
					<div class="form-group">
						<label for="tid">Teacher Name: </label> <input type="text"
							class="form-control" id="tid" placeholder="Enter Class Name" name="tid">
					</div>
					<div class="form-group">
						<label for="sid">Subject Name: </label> <input type="text"
							class="form-control" id="sid" placeholder="Enter Subject Name" name="sid">
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