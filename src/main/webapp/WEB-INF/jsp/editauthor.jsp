<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
	<script src="../../js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="../../css/styles.css">
</head>
<body>
	<p><a href="/">Back to welcome page</a></p>
	<br>
	<h1>Edit author page</h1>
	<br>
	<form method="post" action="/author/${author.id}/edit" class="editForm">
		<div>
			Name<input type="text" name="name" value="${author.name}">
		</div>
		<div>Birtday<input type="text" name="birthday" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${author.birthday}"/>'></div>
		<div>Addess<input type="text" name="address" value="${author.address}"></div>
		<div>Info<input type="text" name="authorInfo" value="${author.authorInfo}"></div>
		<input type="submit" value="Save Changes">
	</form>
		<button><a href="/author">Cancel</a></button>
	
	
	
</body>

</html>