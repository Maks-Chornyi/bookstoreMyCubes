/*function getBookInfoById(id) {
	$.ajax({
		url : 'getBookInfo',
		type : 'GET',
		success : function(result) {
			$('#title').html('Book title: ' + result.title);
			$('#bookId').html('Book ISBN: ' + result.bookId);
			$('#countOfCopies').html('Count of copies: ' + result.countOfCopies);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	$('#myModal').css('display','block');
}*/
function testShortGet(id) {
	$.get('getServerTime', function(data, status){
		alert('Data: ' + data + '\nStatus: ' + status);
	});
}

function getBookInfoById(id) {
	$.get('getBookInfoById/' + id, function(data, status) {
		if(status == 'success') {
			$('#title').html('Book title: ' + data.title);
			$('#bookId').html('Book ISBN: ' + data.bookId);
			$('#countOfCopies').html('Count of copies: ' + data.countOfCopies);
			if(data.bookAuthors[0]) {
				$('#bookAuthors').html('Authors: ' + data.bookAuthors[0].name);
			} else {
				$('#bookAuthors').html('Unknown author');
			}
			$('#myModal').css('display','block');
		} else {
			alert('bad status');
		}
	})
}

function testPost(id) {
	
		$.get('getBookInfoById/' + id, function(data, status) {
			if(status == 'success') {
				alert(data);
			} else {
				alert('bad ');
			}
		});
}

$(document).ready(function() {
	
		$('#id_get_time').click(function() {
			$.get('getServerTime', function(data, status) {
				if(status == 'success') {
					$('#id_time').html(data);
					$('#hideTimeFromServer').css('display','block');
				} else {
					alert('Error');
				}
			});
		});
		
		$('#hideTimeFromServer').click(function() {
			$('#id_time').html('');
			$(this).css('display','none');
		});
		
		$('.close').click(function() {
			$('#myModal').css('display','none');
		});		
	}
);