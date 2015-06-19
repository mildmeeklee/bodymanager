/**
 * 
 */


$(function(){
	$("#write_article").click(function(){
		console.log("write_article clicked!! ");
		var url = "/bodymanager/board/write.do";
		window.location = url;		 
		
	});
	
	$("#write_reply").click(function(){
		console.log("write_reply clicked!!");
		var url = "/bodymanager/board/write.do";
		window.location = url;	
	});
	
/*	$("#write_comments").click(function(){
		console.log("write_reply clicked!!");
		var url = "/bodymanager/board/write.do";
		window.location = url;	
	});*/
});