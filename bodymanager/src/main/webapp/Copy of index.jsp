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
	socket.on('messages', function (data) {
	alert(data.hello);
});
$( document ).ready(function() {

	/* $('#chat_form').on('click', function(e){
		
	var message = $('#chat_input').val();
	console.log("message :: "+message);
	socket.emit('messages', message);
	}); */
	$('.join_btn').on('click', function(){
		var message = $('.join_name').val();
		console.log("message :: "+message);
		socket.emit('messages', message);
	});
	var $chat = $('#chat');
	socket.on('new message', function(data){
		$chat.append(data + "<br/>");
	});
});
</script>
</head>
<body>
<h2>Hello World!</h2>

<div class="send_msg">leave us a message</div>
<div class="join_chat">
	<div class="join_header">
	이름을 입력하세요.
	</div>
	<div class="join_body">
		<div id="chat"></div>
	이름<input type="text" class="join_name">
	</div>
	<div class="join_footer">
	<div class="join_btn">send</div>	
	</div>
</div>

<!-- <div id="contentWrap">
		<div id="chatWrap">
			<div id="chat"></div>
			<form id="send-message">
				<input size="35" id="message"></input>
				<input type="submit"></input>
			</form>
		</div>
		<div id="users"></div>
	</div> -->
</body>
</html>
