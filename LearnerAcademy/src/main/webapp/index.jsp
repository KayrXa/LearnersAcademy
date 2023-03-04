<%-- JSP Page Directive --%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<!--  Java inside HTML 
 -->
 
 	<%@ include file="header.jsp"%>
	

 
 
 

	<h1>Welcome admin on Learnears Academy</h1>
	
	<p>This project is made by Pavel Rygl</p>
	<p>Here you can modify and Students, Teachers, Subjects and Classes</p>

	
	
	
	 <!-- 	out.println("<h2>Hey!!!</h2>");
	out.println("<p>" + new Date() + "</p>");
	String name = request.getParameter("username");
	if (name == null)
		out.println("<p>Welcome GUEST</p>");
	else
		out.println("<p>Welcome " + name.toUpperCase() + "</p>");
	for (int i = 1; i <= 10; i++) {
		out.println("<p>" + i + " : " + i * i + "</p>");
	}
	%>
	<%-- JSP Expressions
do not put ; at the end. it can converts everything strings
 --%>-->
 	
	<h2><%=LocalDateTime.now()%></h2>
	<h2><%=Math.sqrt(25)%></h2> 
	

	<%@ include file="footer.jsp"%>

</body>
</html>