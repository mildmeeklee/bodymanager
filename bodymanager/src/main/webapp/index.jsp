<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="www/css/chat.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="www/js/chat.js"></script>
<script src="http://localhost:9995/socket.io/socket.io.js"></script>
<script>
	/*var socket = io.connect('http://localhost:9995');
	 socket.on('messages', function (data) {
	 alert(data.hello);
	 });*/
	var socket = io.connect('http://localhost:9995');
	socket.on('messages', function(data) {
		alert(data.hello);
	});
	$(document).ready(function() {

		/* $('#chat_form').on('click', function(e){
			
		var message = $('#chat_input').val();
		console.log("message :: "+message);
		socket.emit('messages', message);
		}); */
		
		var $join_name = $('#join_name');
		var $nickError = $('#nickError');
		var $users = $('#users');
		var $messageForm = $('#send-message');
		var $messageBox = $('#message');
		var $chat = $('#chat');
		$('.join_btn').on('click', function() {
			//var message = $('.join_name').val();
			
			/* console.log("send message :: " + message);
			socket.emit('send message', message); */
			console.log("$join_name :: "+ $join_name.val());
			socket.emit('new user', $join_name.val(), function(data){
				if(data){
					$('.join_chat').hide();
					$('#chat_contentWrap').show();
				}else{
					$nickError.html('That username is already taken!  Try again.');
				}
			} );
			//$join_name.val('');
		});
		
		
		socket.on('usernames', function(data){
			var html = '';
			for(i=0; i < data.length; i++){
				html += data[i] + '<br/>'
			}
			$users.html(html);
		});
		
		$messageForm.submit(function(e){
			e.preventDefault();
			socket.emit('send message', $messageBox.val(), function(data){
				$chat.append('<span class="error">' + data + "</span><br/>");
			});
			$messageBox.val('');
			/* socket.emit('send message', $messageBox.val());
			$messageBox.val(''); */
		});
		
		socket.on('new message', function(data){
			$chat.append('<b>' + data.nick + ': </b>' + data.msg + "<br/>");
		});
		
		socket.on('whisper', function(data){
			$chat.append('<span class="whisper"><b>' + data.nick + ': </b>' + data.msg + "</span><br/>");
		});
	});
</script>
</head>
<body>
	<h2>Hello World!</h2>

	<div class="send_msg">leave us a message</div>
	<div class="join_chat">
		<div class="join_header">이름을 입력하세요.</div>
		<div class="join_body">			
			<p id="nickError"></p>
			이름 : <input type="text" class="join_name" id="join_name">
		</div>
		<div class="join_footer">
			<div class="join_btn">send</div>
		</div>
	</div>

	 <div id="chat_contentWrap">
	 <div class="join_header">live chat</div>
		<div id="chatWrap">
			<div id="chat"></div>
			<form id="send-message">
				<input size="35" id="message">
				<input type="submit" value="전송">
			</form>
		</div>
		<div id="users"></div>
	</div> 
</body>
</html>
