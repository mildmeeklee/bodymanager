<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">10
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">10</a></li>
      <li><a href="#">25</a></li>
      <li><a href="#">50</a></li>
        <li><a href="#">100</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">제목
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">작성자</a></li>
      <li><a href="#">제목</a></li>
      <li><a href="#">본문</a></li>
      <li><a href="#">제목 + 본문</a></li>      
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
  <!-- 
   <form class="form-search">
  <input type="text" class="input-medium search-query">
  <button type="submit" class="btn">Search</button>
</form> -->
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
	<div class="row text-right">	
	<!-- <div class="col-md-11"></div> -->
	<div class="col-md-1 col-md-offset-11">
		  	<button type="button" class="btn btn-info" id="write_article">글쓰기</button>
		  	</div>
	</div>
	<div class="row text-center" >	
		<ul class="pagination" >
		<c:if test="${pageMap.currentPage > pageMap.blockPage }">
			<li><a href="/bodymanager/board/boardlist.do?p=${pageMap.startPage -1}">&laquo;</a></li>
		</c:if>
		<c:forEach begin="${pageMap.startPage}" end="${pageMap.endPage}" var="i">	
			
			<c:if test="${i <= pageMap.totalPage }">		  	
		  	<c:choose>
				<c:when test="${i == pageMap.currentPage }">
				<li class="active"><a href="/bodymanager/board/boardlist.do?p=${i}">${i }</a></li>
				</c:when>
		  		<c:otherwise>
		  		<li><a href="/bodymanager/board/boardlist.do?p=${i}">${i }</a></li>
		  		</c:otherwise>		
			</c:choose>
			</c:if>
			</c:forEach>
		<c:if test="${pageMap.totalPage - pageMap.startPage >= pageMap.blockPage }">
			<li><a href="/bodymanager/board/boardlist.do?p=${pageMap.endPage + 1}" >&raquo;</a></li>				
		</c:if>
		<!-- <li class="write-btn_li">
		<button type="button" class="btn btn-info" id="write_article">글쓰기</button>
		</li>-->
		</ul> 
		  
		</div>
