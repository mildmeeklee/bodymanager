<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
	<link rel="stylesheet" type="text/css"	href="/bodymanager/www/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/main.css">

</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h1>My First Bootstrap Page</h1>
			<p>Resize this responsive page to see the effect!</p>
		</div>
		<div class="row">
			<div class="col-md-2">
				
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">자유게시판</a></li>
					<li><a href="#">재테크</a></li>
					<li><a href="#">건강</a></li>
					<li><a href="#">스터디</a></li>
					<li><a href="#">계획</a></li>
				</ul>

			</div>
			<div class="col-md-10">
				<decorator:body />
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/bodymanager/www/js/bootstrap.js"></script>
	<script src="/bodymanager/www/js/board.js"></script>
</body>
</html>