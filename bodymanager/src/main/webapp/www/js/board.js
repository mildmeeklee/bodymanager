/**
 * 
 */


$(function(){
	$("#write_article").click(function(){
		console.log("write_article clicked!! ");
		var url = "/bodymanager/board/write.do";
		window.location = url;		 
		
	});
});