
function blabla() {
	$.post('addBookAjax', $('#formTestPostAjax').serialize());
	window.location.reload;
}

function testShortGet(id) {
	$.get('getServerTime', function(data, status){
		alert('Data: ' + data + '\nStatus: ' + status);
	});
}

function getBookInfoById(id) {
	$.get('getBookInfoById/' + id, function(data, status) {
		$('#titleDialog').html('Book title: ' + data.title);
		$('#bookIdDialog').html('Book ISBN: ' + data.bookId);
		$('#countOfCopiesDialog').html('Count of copies: ' + data.countOfCopies);
	});
	   $("#dialog1").dialog('open');
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
	
		$( "#dialog1" ).dialog({
		    autoOpen: false
		});
		  
		
	
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
