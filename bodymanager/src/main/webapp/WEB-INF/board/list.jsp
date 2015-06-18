<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
<title></title>
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap.css">
	<!-- <link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap.css.map">
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap.css.map"> -->	
</head>
<body>
 <table class="table table-striped">
    <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="result" items="${boardList }" varStatus="status">
    		<tr>
    		<td><c:out value="${status.count }" /></td>
    		<td><a href="detail.do?board_num=<c:out value="${result.board_num }"/>"><c:out value="${result.subject }"/></a></td>
    		<td><c:out value="${result.user_id }"/></td>
    		<td><c:out value="${result.reg_date }"/></td>
    		<td><c:out value="${result.readcount }"/><td>
    		</tr>
    	</c:forEach>
      	
    </tbody>
  </table>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/bodymanager/www/js/bootstrap.js"></script>
	</body>
</html>