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
	<form method="post">
		<input type="text" name=name placeholder="Name" />
		<input type="text" name="birthday" placeholder="Birthday" />
		<input type="text" name="address" placeholder="Address" />
		<input type="text" name="authorInfo" placeholder="Info" />
		<button type="submit">Add author</button>
	</form>
	<form id="deleteAuthorForm" action="/deleteauthor" method="post">
		<input id="deleteAuthor" type="hidden" name="id" value="">
	</form>
	<form id="editAuthorForm" action="/author/${author.id}" method="get">
		<input id="editAuthor" type="hidden" name="id" value="">
	</form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Author info</th>
				<th>Actions</th>
			</tr> 
		</thead>
		<c:forEach items="${authors}" var="author">
		<tr>
			<td><c:out value="${author.name}" /></td>
			<td><c:out value="${author.birthday}" /></td>
			<td><c:out value="${author.address}" /></td>
			<td><c:out value="${author.authorInfo}" /></td>
			<td><button onclick="editAuthorById(${author.id})">Edit</button><button onclick="confirmDeleteAuthor(${author.id})">Delete</button></td>
			
		</tr>
		</c:forEach>
	</table>
	
	
	
	

</body>

</html>