<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
<script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${langs}" var="lang">
	   			<tr>    
	  				<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
	   				<%-- <td><c:out value="${lang.creator}"/></td> --%>
	   				<td><c:out value="${lang.creator}"/></td>
	   				<td><c:out value="${lang.version}"/></td>
	   				<td><a href="/languages/edit/${lang.id}">Edit</a> <a href="/languages/delete/${lang.id}">Delete</a></td>
	   			</tr>
			</c:forEach>
		</table>
		<form:form action="/languages" method="POST" modelAttribute="language" class="d-flex">
			<form:label path="name">Name: 
			<form:input type="text" path="name"/><br></form:label>
			<form:label path="creator">Creator: 
			<form:input type="text" path="creator"/><br></form:label>
			<form:label path="version">Version: 
			<form:input type="text" path="version"/><br></form:label>
			<input type="submit" value="Submit">
			<c:forEach items="${errors}" var="error">
				<p><c:out value="${error.getDefaultMessage()}"/></p>
			</c:forEach>
		</form:form>
	</div>
</body>
</html>