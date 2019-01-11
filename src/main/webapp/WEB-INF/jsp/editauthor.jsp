<!DOCTYPE html>

<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix = "fn" 	uri = "http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
	<script src="/js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/js/jQuery.js"></script>
	
</head>
<body>

	<p><a href="/">Back to welcome page</a></p>
	<br>
	<h2>Edit author page</h2>
	<div class="general-info">
		<p>first p in this div</p>
	</div>
	<form method="post" action="/author/${author.id}/edit" class="editForm">
		<div>
			Name<input type="text" name="name" value="${author.name}">
		</div>
		<div>Birtday<input type="text" name="birthday" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${author.birthday}"/>'></div>
		<div>Addess<input type="text" name="address" value="${author.address}"></div>
		<div>Info<input type="text" name="authorInfo" value="${author.authorInfo}"></div>
		
		<div>
			<select id="authorsBooks" multiple name="authorsBooks" size="5">
				<c:forEach items="${books}" var="book">
					<option value="${book.id}"
					<c:if test="${authorsBooksIds.contains(book.id)}">
					selected</c:if>
					><c:out value="${book.title}" /></option>
				</c:forEach>
			</select>
		</div> 
		<input type="submit" value="Save Changes">
	</form>
		<button><a href="/author">Cancel</a></button>
		
		<div></div>
</body>

</html>