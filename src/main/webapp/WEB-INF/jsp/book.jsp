<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script src="/js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
	<script src="/js/jQuery.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

</head>
<body>
	<p><a href="/">Back to welcome page</a></p>
<!--  	<form id="newBookForm" method="post" action="/addbook">
		<input type="text" name="bookId" placeholder="Insert ISBN of book" />
		<input type="text" name="title" placeholder="book title" />
		<input type="text" name="publishDate" placeholder="date of publishing" />
		<input type="text" name="countOfCopies" placeholder="count of copies" />
		<button type="submit">Add book</button>
	</form> -->
	
	<form id="formTestPostAjax">
		<input type="text" name="bookId" placeholder="Insert ISBN of book" />
		<input type="text" name="title" placeholder="book title" />
		<input type="text" name="publishDate" placeholder="date of publishing" />
		<input type="text" name="countOfCopies" placeholder="count of copies" />
		<button type="submit" onclick="blabla()">Add book</button>
	</form>
	<br>
	<form action="/deletebook" method="post" id="deleteSelectedBookForm">
		<input  id="deleteBookId" type="hidden"  name="id" value="" />
	</form>
	<br>
	
	
	
 	<form id="searchForm">
		<input id="searchInput" type="text" name = "search" placeholder = "Type search word..."/>
	</form>
	<ul class="search-result">
		
	</ul> 
	<br>
	
	<table>
		<tr>
			<th>&#8470;</th>
			<th>ISBN</th>
			<th>Name</th>
			<th>Publish Date</th>
			<th>Count of copies</th>
			<th>Actions</th>
		</tr> 
		
		<%-- <c:forEach begin="0" end="5" varStatus="loop" items="${books}" var="book">
    		Index: ${book.title}<br/>
		</c:forEach> --%>
		<c:forEach items="${books}" var="book" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><c:out value="${book.bookId}" /></td>
				<td><c:out value="${book.title}" /></td>
				<fmt:formatDate pattern='dd/MM/yyyy' type='date' value='${book.publishDate}' var="formattedDate"/>
				<td><c:out value='${formattedDate}'/></td>
				<td><c:out value="${book.countOfCopies}" /></td>
				<td>
					<button onclick="getBookInfoById(${book.id})">Info</button>
					<button onclick="editBookById(${book.id})">Edit</button>
					<button onclick="confirmDeleteBook(${book.id})">Delete</button>
				</td>
			</tr>
		</c:forEach> 
	</table>
	
	<div id="dialog1" title="Dialog Title" hidden="hidden">	
		<p id="titleDialog">hello</p>	
		<p id="bookIdDialog">second</p>	
		<p id="countOfCopiesDialog">third</p>	
	</div>
																<!-- / Dialog window -->
	<button id="id_get_time">Get Server Time</button>
	<button id=hideTimeFromServer>Hide Time</button>
	<br>
	<p id="id_time"></p>
</body>

</html>