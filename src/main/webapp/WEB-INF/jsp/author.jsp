<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<script src="js/main.js"></script>
</head>
<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	<p><a href="/">Back to welcome page</a></p>
	<table>
		<tr>
			<th>Name</th>
			<th>Birthday</th>
			<th>Address</th>
			<th>Author info</th>
		</tr> 
		<c:forEach items="${authors}" var="author">
		<tr>
			<td><c:out value="${author.name}" /></td>
			<td><c:out value="${author.birthday}" /></td>
			<td><c:out value="${author.adress}" /></td>
			<td><c:out value="${author.authorInfo}" /></td>
			<td><button>Edit</button><button onclick="confirmDeleteAuthor()">Delete</button></td>
			
		</tr>
		</c:forEach>
	</table>
</body>

</html>