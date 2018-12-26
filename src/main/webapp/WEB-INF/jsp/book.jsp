<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script src="js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<p><a href="/">Back to welcome page</a></p>
	<br>
	<form method="post" action="/addbook">
		<input type="text" name="bookId" placeholder="Insert ISBN of book" />
		<input type="text" name="title" placeholder="book title" />
		<input type="text" name="publishDate" placeholder="date of publishing" />
		<input type="text" name="countOfCopies" placeholder="count of copies" />
		<button type="submit">Add book</button>
	</form>
	<br>
	<form action="/deletebook" method="post" id="deleteSelectedBookForm">
		<input  id="deleteBookId" type="hidden"  name="id" value="" />
	</form>
	
	<table>
		<tr>
			<th>Num</th>
			<th>ISBN</th>
			<th>Name</th>
			<th>Publish Date</th>
			<th>Count of copies</th>
			<th>Actions</th>
		</tr> 
		<c:forEach items="${books}" var="book" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td><c:out value="${book.bookId}" /></td>
			<td><c:out value="${book.title}" /></td>
			<fmt:formatDate pattern='dd/MM/yyyy' type='date' value='${book.publishDate}' var="formattedDate"/>
			<td><c:out value='${formattedDate}'/></td>
			<td><c:out value="${book.countOfCopies}" /></td>
			<td><button onclick="editBookById(${book.id})">Edit</button><button onclick="confirmDeleteBook(${book.id})">Delete</button></td>
			
		</tr>
		</c:forEach>
	</table>
</body>

</html>