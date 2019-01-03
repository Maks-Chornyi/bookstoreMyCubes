<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script src="/js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/js/jQuery.js"></script>

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
			<th>&#8470;</th>
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
				<td>
					<button onclick="getBookInfoById(${book.id})">Info</button>
					<button onclick="editBookById(${book.id})">Edit</button>
					<button onclick="confirmDeleteBook(${book.id})">Delete</button>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<button id="id_get_time">Get Server Time</button>
	<button id=hideTimeFromServer>Hide Time</button>
	<br>
	<p id="id_time"></p>
	<button onclick="testShortGet(5)">Get Book Info</button>
	<br>
	<br>
	<br>
	<br>


	<!-- Trigger/Open The Modal -->
	<button id="myBtn">Open Modal</button>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close">&times;</span>
	      <h2>Book Info</h2>
	    </div>
	    <div class="modal-body">
	      <p id="title">1</p>
	      <p id="bookId">2</p>
	      <p id="countOfCopies">4</p>
	    </div>
	    <div class="modal-footer">
	      <h4>Modal Footer</h4>
	    </div>
	  </div>
	
	</div>
	
	
	
	
	
	
	
	<!-- <script>
		// Get the modal
		var modal = document.getElementById('myModal');
		
		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		// When the user clicks the button, open the modal 
		btn.onclick = function() {
		  modal.style.display = "block";
		}
		
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		  modal.style.display = "none";
		}
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";
		  }
		}
	</script> -->
</body>

</html>