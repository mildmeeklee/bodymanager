<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../www/css/chat.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://localhost:9995/socket.io/socket.io.js"></script>
<script src="../../www/js/chatAdmin.js"></script>
<title></title>
</head>
<body>
	<div class="a_chatcontent">
		<div id="chatadmin_wrap">
			<div class="chatbg">
				<div id="admin_btn" class="a_chat_title">chattting 관리하기</div>
				<ul class="pages chat_room">
					<li class="chat page">

						<div class="chatArea">
							<div class="messages chat_noti">	
							<br>						
								&nbsp;&nbsp;&nbsp;&nbsp;Welcome to Socket.IO Chat –there are 536 participant<br>																
							</div>
							<div id="users"></div>
							<div id="addchat"></div>

						</div>
						<div class="msgdiv">
							
							<br>
							<select name="select_user" id="select_user">
								<option value="default">default</option>
							</select> 
							<textarea class="inputMessage" placeholder="Type here..." style="width: 760px;"></textarea>
							<button id="send_msg">send</button>
						</div>
					</li>

				</ul>
				<div class="a_chat_footer">by bb project</div>
			</div>
		</div>
	</div>
</body>
</html>