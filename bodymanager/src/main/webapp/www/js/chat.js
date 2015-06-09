/**
 * 
 */
$("document").ready(function() {

	/*
	 * $(".send_msg" ).click(function() { console.log("hello"); });
	 */
	$(".send_msg").on('click', function() {
		console.log("hello");	
		$(".send_msg").css("display", "none");
		$(".join_chat").css("display", "block");
	});

});
