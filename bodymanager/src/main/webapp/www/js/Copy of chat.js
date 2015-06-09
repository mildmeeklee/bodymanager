/**
 * 
 */
$("document").ready(function() {

	/*
	 * $(".send_msg" ).click(function() { console.log("hello"); });
	 */
	$(".send_msg").on('click', function() {
		console.log("hello");
		$(".send_msg").hide();  
		$(".join_chat").show();  
//		 if($(".send_msg").css("display") == "none"){   
//				$(".send_msg").css("display", "block");
//				$(".join_chat").css("display", "none")
//		 } else {  
//				$(".send_msg").css("display", "none");
//				$(".join_chat").css("display", "block")
//		 }  
		
		
//		  jQuery('#id').show();  
//		  jQuery('#id').hide();  
		
		
	});

});
