/**
 * @author
 * mildmeeklee
 * 2015.0611
 * 
 */

var socket = io.connect('http://localhost:9995');


$(document).ready(function() {

		
	var $join_name = $('#join_name');
	var $nickError = $('#nickError');
	var $users = $('#users');
	var $messageForm = $('#send-message');
	var $messageBox = $('#message');
	var $chat = $('#chat');
	
	var nickName;
	
	$(".send_msg").on('click', function() {
		$('#nickError').html("");
		console.log("hello");	
		$(".send_msg").css("display", "none");
		$(".join_chat").css("display", "block");
	});
	
	// 채팅 시작
//	$(document).on('click', '.join_btn' , function() {		
	$('.join_btn').on('click', function() {
		//var socket = io.connect('http://localhost:9995');
		socket.io.reconnecting = undefined; //<- false should be the initial value
		socket.io._reconnection = true;
		socket.connect();
		console.log('socket !!');
		console.log(socket);
		console.log("$join_name :: "+ $join_name.val());
		nickName =  $join_name.val();
		socket.emit('new user', $join_name.val(), function(data){
			if(data){
				$('.join_chat').hide();
				$('#chat_contentWrap').show();
				$chat.append('welcome to, ' + nickName + " !!!<br>");
			}else{
				$nickError.html('That username is already taken!  Try again.');
			}
		} );
	});
	
	
	// 채팅 종료
	$('#exit_chat').on('click', function() {
		
		nickName =  $join_name.val();
		console.log("exit_chat :: nickName :: "+ nickName);
		$('.join_chat').hide();
		$('#chat_contentWrap').hide();
		$('#leave_msg').show();
		socket.emit('user out', nickName, function(data){
			console.log('삭제되었습니다.')
		});
		socket.disconnect();
		$chat.html('');
		$join_name.val('');
		
	});
	
	/*socket.on('usernames', function(data){
		
		var html = '';
		html += data +'<br>';
		 for(i=0; i < data.length; i++){
			html += data[i] + '<br/>'
		} 
		$users.html(html);
	});*/
	
	$messageForm.submit(function(e){
		e.preventDefault();
		socket.emit('new message', $messageBox.val(), function(data){
			console.log('$messageForm.submit !!');
			$chat.append('<span class="error">' + data + "</span><br/>");
		});
		$messageBox.val('');
		
	});
	
	
	// comunicate with new message!!!!!!
	socket.on('new message', function(data){
		
		console.log('new message fire');
		if(nickName==data.nick){
			if(data.admin==true){
				$chat.append('<b>' +  '관리자 : </b>' + data.msg + "<br/>");
			}else{
				$chat.append('<b>' + data.nick + ': </b>' + data.msg + "<br/>");
			}
		}else{
			console.log("other nickNames....emit!!!");
		}
		
	});
	
	
	window.onbeforeunload = function () {
		socket.emit('window beforeunload', nickName, function(data){
			console.log('window beforeunload window beforeunload.');
			console.log(data);
			
			
		});
	   
	};
	
	//$( ".chatwrap_div" ).load( "www/jsp/chatdiv.html" );
});

