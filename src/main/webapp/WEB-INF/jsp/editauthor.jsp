<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<script src="js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	<p><a href="/">Back to welcome page</a></p>
	<br>
	<h1>Edit author page</h1>
	<br>
	<form method="post">
		<p>Name<p><input type="text" value="${author.name}">
	</form>
	<p>${author.name}</p>
	<p>${author.birthday}</p>
	<p>${author.address}</p>
	<p>${author.authorInfo}</p>
</body>

</html>