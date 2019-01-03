
function confirmDeleteBook(id) {
	var confirmation = confirm("Do you really want to delete this book?");
	if(confirmation) {
		document.getElementById("deleteBookId").value = id;
		document.getElementById("deleteSelectedBookForm").submit();
	}
}

function confirmDeleteAuthor(id) {
	var confirmation = confirm("Do you really want to delete this Author?");
	if(confirmation) {
		document.getElementById("deleteAuthor").value = id;
		document.getElementById("deleteAuthorForm").submit();
	}
}

function editAuthorById(id) {
	document.location="/author/" + id + "/edit";
}

function editBookById(id) {
	document.location="/book/" + id + "/edit";
}
