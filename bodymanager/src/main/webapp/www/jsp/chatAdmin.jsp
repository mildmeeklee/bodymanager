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

		
		
		var $users = $('#users');
		var $msg = $(".inputMessage");
		var $chat = $("#addchat");
		$('#admin_btn').on('click', function() {
			
		
			socket.emit('start manage', 'admin', function(data){				
			} );
			//$join_name.val('');
		});
		$('#send_msg').on('click', function() {
			//var message = $('.join_name').val();
			
			/* console.log("send message :: " + message);
			socket.emit('send message', message); */
			console.log("#send_msg on click !!!   $msg :: "+ $msg.val());
			var user = $('#select_user').find(":selected").text();
			console.log('user :: '+user);
			socket.emit('admin send msg', {'msg': $msg.val(), 'user' : user }, function(data){
				//$chat.append('<b>' +  '관리자 : </b>' + data.msg + "<br/>");
				$msg.val();
			} ); 		
			
		});
		
		
		 socket.on('admin', function(data){
			 console.log(data);
			var html = '';
			html += data + '님이 입장하셨습니다. <br/>';
			$("#select_user").append('<option value="'+data+'">'+data+'</option>');
			/* for(i=0; i < data.length; i++){
				html += data[i] + '님이 입장하셨습니다. <br/>';
				$("#select_user").append('<option value="'+data[i]+'">'+data[i]+'</option>');
			} */
			$users.append(html);
		}); 
		
		/* $messageForm.submit(function(e){
			e.preventDefault();
			socket.emit('send message', $messageBox.val(), function(data){
				$chat.append('<span class="error">' + data + "</span><br/>");
			});
			$messageBox.val('');
			/* socket.emit('send message', $messageBox.val());
			$messageBox.val(''); 
		}); */
		
		socket.on('new message', function(data){
			console.log('new message fire');
			if(data.admin==true){
				$chat.append('<b>' +  '관리자 : </b>' + data.msg + "<br/>");
			}else{
				$chat.append('<b>' + data.nick + ': </b>' + data.msg + "<br/>");
			}
		}); 
		/* socket.on('admin new message', function(data){
			console.log('admin fire');
			$chat.append('<b>' + 'admin : </b>' + data.msg + "<br/>");
		}); */
		
		
	});
</script>
<title></title>
</head>
<body>
	<div id="chatadmin_wrap">
		<div id="admin_btn">chattting 관리하기</div>
		<ul class="pages">
			<li class="chat page">
				<div class="chatArea">
					<ul class="messages">
						<li class="log">Welcome to Socket.IO Chat –</li>
						<li class="log">there are 536 participants</li>
					</ul>
					<div id="users"></div>
					<div id="addchat"></div>

				</div>
				<div> 
				<select name="select_user" id="select_user">
					<option value="default">default</option>
				</select> 
				<input class="inputMessage" placeholder="Type here...">
				<button id="send_msg">send</button>
				</div>
			</li>

		</ul>
	</div>
</body>
</html>