/**
 * @author
 * eylee
 * mildmeeklee
 * 2015.0612
 */

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
	});
	$('#send_msg').on('click', function() {
		
		console.log("#send_msg on click !!!   $msg :: "+ $msg.val());
		var user = $('#select_user').find(":selected").text();
		console.log('user :: '+user);
		socket.emit('admin send msg', {'msg': $msg.val(), 'user' : user }, function(data){
			
		} ); 		
		$msg.val('');
	});
	
	
	 socket.on('admin', function(data){
		 console.log(data);
		 var html = '<div class="userinfo">';
			html += data + '님이 입장하셨습니다. <br/>';
			html += '</div>';
		//$("#select_user").append('<option value="'+data+'">'+data+'</option>');
			$("#select_user").append('<option value="'+data+'" id="'+data+'">'+data+'</option>');
			
		/* for(i=0; i < data.length; i++){
			html += data[i] + '님이 입장하셨습니다. <br/>';
			$("#select_user").append('<option value="'+data[i]+'">'+data[i]+'</option>');
		} */
		$users.append(html);
	}); 
	
	 socket.on('admin receive msg', function(data){
		console.log('admin receive msg init!!');
		console.log(data);			
		$chat.append('<div class="chatmsg"><b>' + data.nick + ': </b>' + data.msg + "<br/></div>");
	}); 
	 
	
	socket.on('new message', function(data){
		console.log('new message fire');
		if(data.admin==true){
			$chat.append('<div class="chatmsg"><b>' +  '관리자 : </b>' + data.msg + "<br/></div>");
		}/* else{
			$chat.append('<b>' + data.nick + ': </b>' + data.msg + "<br/>");
		} */
	}); 
		
	
	socket.on('disconnect user', function(data){
		console.log('disconnect user fire');
		console.log('data');
		console.log(data);
		//var $selectbox = $('#select_user');		
		//console.log($selectbox)
		console.log(data);
		//var $myoption = $selectbox.val(data);
		//console.log($myoption);
		  
		var $myoption = $("#select_user option[value='"+data+"']");
		$myoption.remove();
		var html = '<div class="userinfo">';
		html += data + '님이 퇴장하셨습니다. ';
		html += '</div>';
		$users.append(html);			
	}); 
	
	
	
	
});