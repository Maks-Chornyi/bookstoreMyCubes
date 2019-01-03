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
	<h1>Edit author page</h1>
	<form method="post" action="/book/${book.id}/edit">
		<div>
			ISBN: <input type="text" name=bookId value="${book.bookId}">
		</div>
		<div>Title: <input type="text" name="title" value="${book.title}"></div>
		<div>Publish Date: <input type="text" name="publishDate" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${book.publishDate}"/>'></div>
		<div>Count of Copies: <input type="text" name="countOfCopies" value="${book.countOfCopies}"></div>
		<div>
			<c:choose>
				<c:when test="${booksAuthors.size() == 0}">
					<p>There is no author of this book</p>
				</c:when>
				<c:otherwise>
					<h3>Author(s) of this book</h3>
					<c:forEach items="${booksAuthors}" var="author">
						<p>${author.name}</p>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<input type="submit" value="Save Changes">
	</form>
	
	
	<button><a href="/book">Cancel</a></button>
		
</body>

</html>