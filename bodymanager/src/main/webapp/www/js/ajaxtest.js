/**
 * 
 */
$(function() {
	console.log("ready!");

});

$('#gotimetable').on('click', function() {
	console.log('gogo');
	var url = 'timetablelist.do';
	window.location = url;
	// 'noticedelete.do?n_num=${noticelist.n_num}
});

$("#get_select_title").on('click', function() {
	console.log("hello");
	var user = "eylee";
	var hi = "hello";
	var jsonData = '{"userID":"' + user + '"}';
	/*$.post('gettitlelist.do', jsonData , function(data){
		$('#title_feedback').html(data);
	});*/
	//type : 'POST',
//	type : 'GET',
	$.ajax({
		
		type : 'GET',
		Accept : "application/json",
		contentType : "application/json",
		dataType : 'json',
		url : "gettitlelist.do?userID="+user,
		data : '{"hi":"' + hi + '"}',
		success : function(data) {
			console.log("select_title data!!!!!");
			console.log(data);
			console.log("select_title data!!!!!");
			
			console.log('select_title in ajax call success');
			var select_titleResult = data.result.data;
			
			if (select_titleResult) {
				if (!data.result.errors) {
					console.log("성공!!");
				} else {
					console.log(data.result.errors[0]);
									}
			} else {
				console.log('쿼리 조회 실패 하였습니다.');
				
			}

		},
		error : function(data, textStatus, request) {
			console.log('fail start...........');
			console.log(data);
			console.log(textStatus);
			console.log('fail end.............');
			alert('쿼리 조회 실패 하였습니다.');			
		}

	});
});


$("#post_select_title").on('click', function() {
	console.log("hello");
	var user = "eylee";
	var hi = "hello";
//	var jsonData = '{"userID":"' + user + '"}';
	 var jsonData = {
		      "userID" : "eylee"
	 }
	/*$.post('gettitlelist.do', jsonData , function(data){
		$('#title_feedback').html(data);
	});*/
	//type : 'POST',
//	type : 'GET',
	$.ajax({
		
		type : 'POST',
		Accept : "application/json",
		contentType : "application/json",
		dataType : 'json',
		url : "gettitlelist.do",
//		data : jsonData,
		data: JSON.stringify(jsonData), // Note it is important
		success : function(data) {
			console.log("select_title data!!!!!");
			console.log(data);
			console.log("select_title data!!!!!");
			
			console.log('select_title in ajax call success');
			var select_titleResult = data.result.data;
			
			if (select_titleResult) {
				if (!data.result.errors) {
					console.log("성공!!");
				} else {
					console.log(data.result.errors[0]);
									}
			} else {
				console.log('쿼리 조회 실패 하였습니다.');
				
			}

		},
		error : function(data, textStatus, request) {
			console.log('fail start...........');
			console.log(data);
			console.log(textStatus);
			console.log('fail end.............');
			alert('쿼리 조회 실패 하였습니다.');			
		}

	});
});