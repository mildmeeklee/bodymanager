<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="/bodymanager/www/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/bodymanager/www/css/main.css">
</head>
<body>

	<div class=" row">
		<form method="post">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text" class="form-control"
				id="title">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" id="content"></textarea>
		</div>
		<div class="form-group">
			<label for="usr">작성자:</label> <input type="text" class="form-control"
				id="usr">
		</div>
		작성일 :
		</form>
	</div>
	
	<div class=" row">
		<button type="button" class="btn btn-info">저장</button>
		<button type="button" class="btn btn-warning">취소</button>
		<button type="button" class="btn btn-primary">목록가기</button>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/bodymanager/www/js/bootstrap.js"></script>
	<script src="/bodymanager/www/js/board.js"></script>
</body>
</html>