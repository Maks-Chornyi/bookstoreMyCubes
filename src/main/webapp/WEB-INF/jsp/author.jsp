<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
	<script src="/js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<p><a href="/">Back to welcome page</a></p>
	<div class="general-info">
		<p>Amount of all authors: <strong>${countOfAllAuthors}</strong></p>
		<p>Oldest author is: <strong>${oldestAuthor.name}</strong></p>
		<p>Youngest author is: <strong>${youngestAuthor.name}</strong></p>
		<p>Most successful authors is: <strong>${mostSuccessfulAuthor.name}</strong>, author has <strong>${countOfBooksOfMostSuccessfulAuthor}</strong> published books</p>
		<p>The author who published lowest count of books is: <strong>${lowestPublishedAuthor.name}</strong>. Author has <strong>${countOfBooksOfUnSuccessfulAuthor}</strong> published books</p>
		<p>best rates author: <strong>${mostProductiveAuthor.name}</strong>. Author sale <strong>${averageSaleOfMostProductiveAuthor}</strong> books in average</p>
	</div>
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
				<th>&#8470;</th>
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