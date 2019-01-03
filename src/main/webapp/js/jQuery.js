
$(document).ready(function() {
		
		$("#id_get_timez").click(function() {
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
		
		$("#get_book_info").click(function() {
			$.ajax({
				url : 'getBookInfo',
				type : 'GET',
				dataType: 'json',
				success : function(result) {
					alert("Hello maN");
				},
				error : function(e) {
					console.log(e);
				}
			});
		});
	}
);