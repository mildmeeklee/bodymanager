/**
 * 
 */


$(function(){
	
	// normal article
	$("#write_article").click(function(){
		console.log("write_article clicked!! ");
		var url = "/bodymanager/board/writeform.do";
		window.location = url;		 
		
	});
	
	// reply article
	$("#write_reply").click(function(){
		console.log("write_reply clicked!!");
		var board_num = $("#board_num").val();
		var ref_g = $("#ref_g").val();
		var re_step = $("#re_step").val();
		var re_level = $("#re_level").val();
		
		console.log("board_num :: "+board_num +", re_step :: "+re_step+", re_step :: "+re_step+", re_level :: "+re_level);
		var url = "/bodymanager/board/writeform.do?board_num="+board_num+"&ref_g="+ref_g+"&re_step="+re_step+"&re_level="+re_level;
		window.location = url;	
	});
	
/*	$("#write_comments").click(function(){
		console.log("write_reply clicked!!");
		var url = "/bodymanager/board/write.do";
		window.location = url;	
	});*/	
	


});

// article modify
function gotoUpdateForm(board_num, p){
//	var currentWriter = '<%=article.getWriter()%>';
//	var id = '<%=id%>';
//	console.log(currentWriter + " : "+id);
//	if(currentWriter == id){		
		 var contextPath = $("#context").val();
//		 var board_num = $("#board_num").val();
		 console.log("contextPath :: "+contextPath);
		 console.log("board_num :: "+board_num +", p :: "+p);
//		 var url = contextPath+'/board/updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>';
		 var url = contextPath+'/board/updateform.do?board_num='+board_num+'&p='+p;
		 window.location = url;
		 
//	}else{
//		alert("같은 id의 게시자만 수정할 수 있습니다.");
//	}
}

// go to list page -- in  wirte pages, if press go to list , u cannot go to current page. just loading 1 page(cuz, there's no currentPage parameter)
function gotoList(currentPage){
//	${cpageMap.currentPage }
	var contextPath = $("#context").val();
	console.log("currentPage :: "+currentPage +", contextPath :: "+contextPath);
//	http://localhost:8089/bodymanager/board/undefined/board/boardlist.do
	if(currentPage ==undefined || currentPage == null){
		console.log(currentPage);
		var url = '/bodymanager/board/boardlist.do';
	}else{
		var url = contextPath+'/board/boardlist.do?p='+currentPage;
	}
	window.location = url;
}

// cancel
function goBack(){
	console.log("cancel clicked!!");
	history.go(-1);
	
}

// delete Article
function deleteArticle(board_num ,currentPage){
	console.log("deleteArticle clicked!!");
	var contextPath = $("#context").val();
	var url = contextPath+'/board/deletearticle.do?p='+currentPage+"&board_num="+board_num;
	console.log(url);
	// modal start
	
	bootbox.confirm({
	    buttons: {
	        confirm: {
	            label: '확인',
	            className: 'btn-danger'
	        },
	        cancel: {
	            label: '취소',
	            className: 'btn-default'
	        }
	    },
	    message: '삭제하시겠습니까?',
	    callback: function(result) {
	    	if (result) {
		        console.log("User confirmed dialog");
		        window.location = url;
		        alert("삭제되었습니다."+result);
		    } else {
		        console.log("User declined dialog");
		        alert("취소되었습니다."+result);
		    }
	    },
	    title: "안내",
	});
	
	
}

 

