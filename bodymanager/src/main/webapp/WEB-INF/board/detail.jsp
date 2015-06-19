<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
	<div class="panel-heading">제목: ${article.subject }
		조회:${article.readcount }</div>
	<div class="panel-body">${article.content }</div>
	<div class="panel-footer">${article.user_id }, ${article.reg_date }</div>
</div>

<div class="row">
	<div class="col-md-9">

		<a href="#" class="btn btn-primary btn-md"> 
		<span	class="glyphicon glyphicon-thumbs-up"></span> Like
		</a> <a href="#" class="btn btn-default btn-md"> 
		<span class="glyphicon glyphicon-thumbs-down"></span> Unlike
		</a>
	</div>
	<div class="col-md-3 btn-g-detail">
		<button type="button" class="btn btn-info">글목록</button>
		<button type="button" class="btn btn-success" id="write_reply">답글쓰기</button>
		<button type="button" class="btn btn-warning">수정</button>
		<button type="button" class="btn btn-danger">삭제</button>
	</div>
</div>
<!-- <div class=""
<div class="panel panel-info">
	<div class="panel-heading">댓글 쓰기</div>
	<div class="panel-body">Panel Content</div>
</div> -->

<div class="panel panel-info">
    <div class="panel-heading">댓글 쓰기</div>
    <div class="panel-body">
      <form class="form-inline" role="form" method="post" action="/bodymanager/board/writecomment.do"> 
      		<input type="hidden" name="board_num" value="${article.board_num }">
		   <div class="form-group">
					<label for="comments"></label>
					<textarea class="form-control" rows="5" name="comment"  placeholder="댓글을 달아주세요" cols="155"></textarea>
				</div>
		  <button type="submit" class="btn btn-default btn-lg btn-comments-detail" id="write_comments">등록</button>
	</form>

    </div>
    
  </div>
 <!--  댓글이 있으면 -->
<c:if test="${cpageMap.totalCount > 0 }">
  <table class="table">
    <thead>
      <tr>
        <th >${cpageMap.totalCount }개의 댓글</th>       
      </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${clist }" varStatus="status">
    	<tr>
    	<td>
    	<div class="row">
    		<div class="col-md-2 comment_box">
    			<p class="small">
    			<c:out value="${result.reg_date }"/>    			
    			</p>
		     
    		</div>
    		<div class="col-md-6">
       		 <a href="#">
         		 <span class="glyphicon glyphicon-pencil">수정</span>
       		 </a>
    		<a href="#">
		          <span class="glyphicon glyphicon-remove">삭제</span>
		     </a>
    		</div>
    		<div class="col-md-3 text-center" >
    			<a href="#">
		          <span class="glyphicon glyphicon-thumbs-up"></span>
		        </a>
    			 <a href="#">
		          <span class="glyphicon glyphicon-thumbs-down"></span>
		        </a>
    		</div>
    	</div>
    	<div class="row comment_box">
    	<c:out value="${result.c_content }"/>
    	</div>
    	<div class="row comment_box">
    	<p class="small"><c:out value="${result.user_id }" /></p>
    	</div>
    	
    	
    	</td>
    	</tr>
    </c:forEach>
    </tbody>
  </table>
  <div class="row text-center" >	
<ul class="pagination" >
<c:if test="${cpageMap.currentPage > cpageMap.blockPage }">
	<li><a href="/bodymanager/board/detail.do?p=${cpageMap.startPage -1}&board_num=${article.board_num }">&laquo;</a></li>
</c:if>
<c:forEach begin="${cpageMap.startPage}" end="${cpageMap.endPage}" var="i">	
	
	<c:if test="${i <= cpageMap.totalPage }">		  	
  	<c:choose>
		<c:when test="${i == cpageMap.currentPage }">
		<li class="active"><a href="/bodymanager/board/detail.do?p=${i}&board_num=${article.board_num }">${i }</a></li>
		</c:when>
  		<c:otherwise>
  		<li><a href="/bodymanager/board/detail.do?p=${i}&board_num=${article.board_num }">${i }</a></li>
  		</c:otherwise>		
	</c:choose>
	</c:if>
	</c:forEach>
<c:if test="${cpageMap.totalPage - cpageMap.startPage >= cpageMap.blockPage }">
	<li><a href="/bodymanager/board/detail.do?p=${cpageMap.endPage + 1}&board_num=${article.board_num }" >&raquo;</a></li>				
</c:if>

</ul> 
  
</div>
</c:if>