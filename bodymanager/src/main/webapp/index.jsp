<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="www/css/chat.css">
<link rel="stylesheet" type="text/css" href="www/css/ajax.css">

</head>
<body>
	<h2>Hello World!</h2>
	<div class="ajax_test" id="gotimetable">ajax test</div>
	<div class="send_msg" id="leave_msg">leave us a message</div>
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
		<div class="join_header">
			live chat<input type="button" value="종료" id="exit_chat"
				class="chat_exitBtn">
		</div>
		<div id="chatWrap">
			<div id="chat"></div>
			<form id="send-message">
				<input size="35" id="message"> <input type="submit"
					value="전송">
			</form>
		</div>
		<div id="users"></div>
	</div>
<div>

<a  href="timetable/timetablelist.do">timetablelist</a>>
</div>
	<!-- <div class="chatwrap_div"></div> -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://localhost:9995/socket.io/socket.io.js"></script>
	<script src="www/js/ajaxtest.js"></script>
	<script src="www/js/chatClient.js"></script>
</body>
</html>
