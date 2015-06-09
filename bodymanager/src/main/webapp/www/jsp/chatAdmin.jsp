<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../www/css/chat.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="../../www/js/chat.js"></script>
<script src="http://localhost:9995/socket.io/socket.io.js"></script>
<script>
	/*var socket = io.connect('http://localhost:9995');
	 socket.on('messages', function (data) {
	 alert(data.hello);
	 });*/
	var socket = io.connect('http://localhost:9995');
	
	$(document).ready(function() {

		/* $('#chat_form').on('click', function(e){
			
		var message = $('#chat_input').val();
		console.log("message :: "+message);
		socket.emit('messages', message);
		}); */
		
		var $addchat = $('#addchat');
		
		$('#admin_btn').on('click', function() {
			//var message = $('.join_name').val();
			
			/* console.log("send message :: " + message);
			socket.emit('send message', message); */
			console.log("$join_name :: "+ $join_name.val());
			socket.emit('admin', 'admin', function(data){
				
			} );
			//$join_name.val('');
		});
		
		
		socket.on('admin', function(data){
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
<title></title>
</head>
<body>
<div id="chatadmin_wrap">
<div id="admin_btn" >chattting 관리하기</div>
<ul class="pages">
    <li class="chat page" >
      <div class="chatArea">
        <ul class="messages"><li class="log" >Welcome to Socket.IO Chat – </li>
        <li class="log" >there are 536 participants</li></ul>
        <div id="addchat"></div>
      </div>
      <input class="inputMessage" placeholder="Type here...">
    </li>
    
  </ul>
</div>
</body>
</html>