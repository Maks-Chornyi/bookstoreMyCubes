function getBookInfoById(id) {
	$.ajax({
		url : 'getBookInfo',
		type : 'GET',
		success : function(result) {
			$("#title").html("Book title: " + result.title);
			$("#bookId").html("Book ISBN: " + result.bookId);
			$("#countOfCopies").html("Count of copies: " + result.countOfCopies);
		},
		error : function(e) {
			alert("Error: " + e);
		}
	});
	showModalWindow();
}

function showModalWindow() {
	$('#myModal').css('display','block');
}


$(document).ready(function() {
		
		$("#id_get_time").click(function() {
			$.ajax({
				url : 'getServerTime',
				success : function(data) {
					$("#id_time").html(data);
				}
			});
			showButtonWhichHideTime();
		});
		
		function showButtonWhichHideTime() {
			$("#hideTimeFromServer").css("display","block");
		}
		
		$("#hideTimeFromServer").click(function() {
			$("#id_time").html("");
			$(this).css("display","none");
		});
		
		$('.close').click(function() {
			$('#myBtn').css('display','none');
		});		
		
		$("#myBtn").click(function() {
			$.ajax({
				url : 'getBookInfo',
				type : 'GET',
/*				contentType: 'application/json',
				dataType: 'json',*/
				success : function(result) {
					$("#title").html("Book title: " + result.title);
					$("#bookId").html("Book ISBN: " + result.bookId);
					$("#countOfCopies").html("Count of copies: " + result.countOfCopies);
				},
				error : function(e) {
					alert("Error: " + e);
				}
			});
		});
	}
);