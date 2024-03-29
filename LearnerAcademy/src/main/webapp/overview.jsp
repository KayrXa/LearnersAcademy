<%@page import="com.bean.Students"%>
<%@page import="com.bean.Classes"%>
<%@page import="com.bean.Teachers"%>
<%@page import="com.bean.ClassesSubjectsTeacherLink"%>
<%@page import="com.bean.Subjects"%>

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
			<th>Class name</th>
			<th>Edit</th>
			<th>Delete</th>
					</tr>
					
	<!-- display every relation -->				
<c:forEach items="${requestScope.relList}" var="rel">		
   	<c:forEach items="${requestScope.classList}" var="cl">
    		<h4>${cl.name}</h4>
    		<h5>Students</h5>
    		<ul>
    			<c:forEach items="${requestScope.studentList}" var="st">
    				<c:if test="${st.cid == cl.cid}">
						<li>${st.name} ${st.sur} ${st.brthno} ${st.phone} ${st.email}</li>
					</c:if>
    			</c:forEach>
    		</ul>
    		
	<!-- WORKING ON IT
    		<h5>Teachers</h5>
    			<c:forEach items="${requestScope.teacherList}" var="tchr">
    						
    						
    						<c:if test="${tchr.tid == rel.teachers}">
						<li>${tchr.name} ${tchr.sur} ${tchr.sur} ${tchr.brthno} ${tchr.phone} ${tch.email}</li>
							</c:if>
    			</c:forEach>
    		
    		<br>
    		<h5>Subjects</h5>
    			<c:forEach items="${requestScope.teacherList}" var="tchr">
    				
					<li>${tchr.name} ${tchr.sur} ${tchr.sur} ${tchr.brthno} ${tchr.phone} ${tch.email}</li>
					
    			</c:forEach>
     -->			
    		<br>
	</c:forEach>
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