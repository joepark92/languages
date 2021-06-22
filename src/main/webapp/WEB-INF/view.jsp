<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${lang.name}</title>
</head>
<body>
	<a href="/languages">Dashboard</a><br>
	<c:out value="${lang.name}"/><br>
	<c:out value="${lang.creator}"/><br>
	<c:out value="${lang.version}"/><br>
	<a href="/languages/delete/${lang.id}">Delete</a><br>
	<a href="/languages/edit/${lang.id}">Edit</a>
</body>
</html>