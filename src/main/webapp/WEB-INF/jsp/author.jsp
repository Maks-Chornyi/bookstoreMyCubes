<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
	<script src="js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<p><a href="/">Back to welcome page</a></p>
	<br>
	<form method="post" action="/addAuthor">
		<input type="text" name=name placeholder="Name" />
		<input type="text" name="birthday" placeholder="Birthday" />
		<input type="text" name="address" placeholder="Address" />
		<input type="text" name="authorInfo" placeholder="Info" />
		<button type="submit">Add author</button>
	</form>
	<form id="deleteAuthorForm" action="/deleteauthor" method="post">
		<input id="deleteAuthor" type="hidden" name="id" value="">
	</form>

	<table>
	<div class="shownCount">
		<%! int amount = 0; %>
		<% amount++; %>
		This page was shown <%= amount %> times
	</div>
		<thead>
			<tr>
				<th>num</th>
				<th>Name</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Author info</th>
				<th>Actions</th>
			</tr> 
		</thead>
		<c:forEach items="${authors}" var="author" varStatus="status"> 
			<tr>
				<td>${status.count}</td>
				<td><c:out value="${author.name}" /></td>
				<fmt:formatDate pattern='dd/MM/yyyy' type='date' value='${author.birthday}' var="formattedDate"/>
				<td><c:out value="${formattedDate}" /></td>
				<td><c:out value="${author.address}" /></td>
				<td><c:out value="${author.authorInfo}" /></td>
				<td><button><a href="/author/${author.id}/edit">Edit</a></button><button onclick="confirmDeleteAuthor(${author.id})">Delete</button></td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	

</body>

</html>