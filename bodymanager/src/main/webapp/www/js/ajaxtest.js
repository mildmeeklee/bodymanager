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

/**
 *  eylee
 *  mildmeeklee
 *  2015.06.11
 *  add ajax /get method
 */ 

$("#get_select_title").on('click', function() {
	console.log("hello");
	var user = "eylee";
	var hi = "hello";
//	var jsonData = '{"userID":"' + user + '"}';
	var jsonData = {"userID" : user};
	/*$.post('gettitlelist.do', jsonData , function(data){
		$('#title_feedback').html(data);
	});*/
	//type : 'POST',
//	type : 'GET',
	
	/*var selectedProgram = this.selectedOptions[0].value;
	   console.log('selectedProgram :: '+selectedProgram);
	   */
	   
	   
		
		$.ajax({
			
			type : 'GET',
			Accept : "application/json",
			contentType : "application/json; charset=UTF-8",
			dataType : 'json',
			url : "gettitlelist.do",
			data : jsonData,
			success : function(data) {
				console.log("select_title data!!!!!");
				console.log(data);
				console.log("select_title data!!!!!");
				var a = data[0].charge;
				var b = data[0].content;
				var c = data[0].goal;
				var html;
			
				for (i = 0; i < data.length; i++) { 
					html += data[i].charge +'<br>';
					html += data[i].content+'<br>';
					html += data[i].goal+'<br>';		
					
				}
				console.log('select_title in ajax call success');
				$('#title_feedback').append(html);
				

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


