<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<script src="js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<%-- 	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>--%>
	<p><a href="/">Back to welcome page</a></p>
	<br>
	<form method="post">
		<input type="text" name="isbn" placeholder="Insert ISBN of book" />
		<input type="text" name="title" placeholder="book title" />
		<input type="text" name="publishDate" placeholder="date of publishing" />
		<input type="text" name="countOfCopies" placeholder="count of copies" />
		<button type="submit">Add book</button>
	</form>
	<br>
	<table>
		<tr>
			<th>ISBN</th>
			<th>Name</th>
			<th>Publish Date</th>
			<th>Count of copies</th>
			<th>Actions</th>
		</tr> 
		<c:forEach items="${books}" var="book">
		<tr>
			<td><c:out value="${book.bookId}" /></td>
			<td><c:out value="${book.title}" /></td>
			<td><c:out value="${book.publishDate}" /></td>
			<td><c:out value="${book.countOfCopies}" /></td>
			<td><button>Edit</button><button onclick="confirmDeleteBook()">Delete</button></td>
			
		</tr>
		</c:forEach>
	</table>
</body>

</html>