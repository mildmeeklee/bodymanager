<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="/bodymanager/www/css/bootstrap.css">
<!-- <link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap.css.map">
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="/bodymanager/www/css/bootstrap.css.map"> -->
</head>
<body>
 <ul class="dropdown-menu">
      <li class="dropdown-header">Dropdown header 1</li>
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li class="dropdown-header">Dropdown header 2</li>
      <li><a href="#">About Us</a></li>
    </ul>
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
			<c:forEach var="result" items="${list }" varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><a
						href="detail.do?board_num=<c:out value="${result.board_num }"/>"><c:out
								value="${result.subject }" /></a></td>
					<td><c:out value="${result.user_id }" /></td>
					<td><c:out value="${result.reg_date }" /></td>
					<td><c:out value="${result.readcount }" />
					<td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<ul class="pager">
	<c:if test="${pageMap.currentPage > pageMap.blockPage }">
		<li><a href="/bodymanager/board/boardlist.do?p=${pageMap.startPage -1}">Previous</a></li>
	</c:if>    
		
		<ul class="pagination">
		<c:forEach begin="${pageMap.startPage}" end="${pageMap.endPage}" var="i">	
			
			<c:if test="${i > pageMap.totalPage }">
		  		<% break; %>
		  	</c:if>
		  	<c:choose>
				<c:when test="${i == pageMap.currentPage }">
				<li class="active"><a href="/bodymanager/board/boardlist.do?p=${i}">${i }</a></li>
				</c:when>
		  		<c:otherwise>
		  		<li><a href="/bodymanager/board/boardlist.do?p=${i}">${i }</a></li>
		  		</c:otherwise>		
			</c:choose>
			</c:forEach>
		</ul>
			<c:if test="${pageMap.totalPage - pageMap.startPage >= pageMap.blockPage }">
		<li><a href="/bodymanager/board/boardlist.do?p="${pageMap.endPage + 1}">Next</a></li>				
		</c:if>
	</ul>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/bodymanager/www/js/bootstrap.js"></script>
</body>
</html>