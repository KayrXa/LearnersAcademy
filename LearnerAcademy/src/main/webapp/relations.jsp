<%@page import="com.bean.ClassesSubjectsTeacherLink"%>
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
	
	
	<!-- Actual relations -->
	
	<h1>Relation table</h1>
	
	
	<div class="container">
	<table class="table">
		<tr>
				<th>Id</th>
				<th>Class Id</th>
				<th>Subject Id</th>
				<th>Teacher Id</th>
			
			</tr>		
		<c:forEach var="rel" items="${requestScope.relList }">
			<tr>
				<td>${rel.id}</td>
				<td>${rel.classes}</td>
				<td>${rel.teachers}</td>
				<td>${rel.subjects}</td>
				<td><a href="edit?email=${rel.id}">Edit</a> </td>
				<td><a href="delete?email=${rel.id}">Del</a> </td>
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
		<form action="relations" method="post">

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
					
				<!-- Preparation for option list from DB -->
				<div class="form-group">
						<label for="sid">Subject Name: </label> 
						<select>
							<option value=1 id="sid">1</option>
							<option value=2 id="sid">2</option>
							<option value=3 id="sid">3</option>
						</select>
						
						<label for="sid">Teacher Name: </label> 
						<select>
							<option value=1 id="tid">1</option>
							<option value=2 id="tid">2</option>
							<option value=3 id="tid">3</option>
						</select>
						
						<label for="sid">Class Name: </label> 
						<select>
							<option value=1 id="cid">1</option>
							<option value=2 id="cid">2</option>
							<option value=3 id="cid">3</option>
						</select>
							
							
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