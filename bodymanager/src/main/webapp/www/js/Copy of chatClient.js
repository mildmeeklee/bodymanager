/**
 * @author
 * mildmeeklee
 * 2015.0611
 * 
 */

var socket = io.connect('http://localhost:9995');
	
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
	
	var nickName;
	// 채팅 시작
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
			}else{
				$nickError.html('That username is already taken!  Try again.');
			}
		} );
		//$join_name.val('');
	});
	
	
	// 채팅 종료
	$('#exit_chat').on('click', function() {
		
		nickName =  $join_name.val();
		console.log("exit_chat :: nickName :: "+ nickName);
		$('.join_chat').hide();
		$('#chat_contentWrap').hide();
		$('#leave_msg').show();
		//socket.disconnect();
		socket.emit('user delete', nickName, function(data){
			console.log('삭제되었습니다.')
		});
		socket.disconnect();
		$join_name.val('');
		//socket.close();
		/* socket.emit('disconnect', nickName, function(data){
			console.log('callback!! ');
			if(data){
			
			}else{
				$nickError.html('채팅 종료에 실패했습니다.');
			}
		} ); */
		//$join_name.val('');
	});
	
	socket.on('usernames', function(data){
		
		var html = '';
		html += data +'<br>';
		/* for(i=0; i < data.length; i++){
			html += data[i] + '<br/>'
		} */
		$users.html(html);
	});
	
	$messageForm.submit(function(e){
		e.preventDefault();
		socket.emit('send message', $messageBox.val(), function(data){
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
	
	
});

	
	
	/*var socket = io.connect('http://localhost:9995');
	 socket.on('messages', function (data) {
	 alert(data.hello);
	 });*/
	