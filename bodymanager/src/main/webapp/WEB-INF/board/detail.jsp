<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="/bodymanager/www/css/bootstrap.css">
</head>
<body>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title">
	</div>
	<div class="form-group">
		<label for="content">Comment:</label>
		<textarea class="form-control" rows="5" id="content"></textarea>
	</div>
	<button type="button" class="btn btn-default">Default</button>
	<button type="button" class="btn btn-primary">Primary</button>
	<button type="button" class="btn btn-success">Success</button>
	<button type="button" class="btn btn-info">Info</button>
	<button type="button" class="btn btn-warning">수정</button>
	<button type="button" class="btn btn-danger">삭제</button>
	<button type="button" class="btn btn-link">Link</button>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/bodymanager/www/js/bootstrap.js"></script>
</body>
</html>