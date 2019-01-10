
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
	
		var timeoutID = null;
		function findMember(str) {
			$('ul.search-result li').remove();
			if(!str && str.length == 0) return;
			console.log('search: ' + str);
			$.post('bookSearch', $('#searchForm').serialize(), function(data, status) {
				if(status == "success") {
					if(data.length > 0) {
						var maxCountOfSuggestions = 5;
						for(var i = 0; i < data.length && i < maxCountOfSuggestions; i++) {
							var elem = data[i];
							var a = $("<a />", {
								href : "/book/" + elem.id + "/edit"
							});
							var book = $("<li></li>").text(elem.title);
							a.append(book);
							$('ul.search-result').append(a);
						}
					} else {
						var noSuggestionsForSearch = $("<li></li>").text("No results for: '" + str + "'");
						$('ul.search-result').append(noSuggestionsForSearch);
					}
				} else {
					alert("Smth went wrong. Status: " + status);
				}
			});
		}
		
		$('#searchInput').keyup(function(e) {
			clearTimeout(timeoutID);
			timeoutID = setTimeout(() => findMember(e.target.value), 500);
		});
	
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
