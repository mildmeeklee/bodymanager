<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<input type="hidden" id="context" value="${context}">
	<div class=" row">
		
		<div class="panel panel-default">
		    <div class="panel-heading">게시글 수정하기</div>
		    <div class="panel-body">
		     
		      <form class="form-horizontal" role="form"  method="post" action="/bodymanager/board/updatesave.do">
		      	<input type="hidden" name="p" value='<c:out value="${p}"/>'>
		      	<input type="hidden" name="board_num" value='<c:out value="${article.board_num }"/>'>
		      	<input type="hidden" name="ref_g" value='<c:out value="${article.ref_g}"/>'>
		      	<input type="hidden" name="re_step" value='<c:out value="${article.re_step }"/>'>
		      	<input type="hidden" name="re_level" value='<c:out value="${article.re_level }"/>'>
		      	<input type="hidden" name="readcount" value='<c:out value="${article.readcount }"/>'>
				<div class="form-group">
					<label for="subject" class="col-md-1 control-label">제목 </label> 
					 <div class="col-md-11">
					<input type="text" class="form-control"	id="subject" name="subject" value="${article.subject }">
					</div>
				</div>
				
				<div class="form-group">
					  <label for="cat_id"  class="col-md-1 control-label" >카테고리 </label>
					   <div class="col-md-11">
					  <select class="form-control" id="cat_id" name="cat_id" >
					    <option value="1">1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					  </select>
					   <p class="help-block">카테고리를 선택해 주세요.</p>
					  	</div>
					</div>
					<div class="form-group">
					<label for="content" class="col-md-1 control-label">내용 </label>
					 <div class="col-md-11">
					<textarea class="form-control" rows="10"  name="content" >${article.content }</textarea>
					</div>
				</div>
				
				<!-- <div class="form-group">
					<label for="usr" class="col-md-1 control-label">작성자</label> 
					  <div class="col-md-11">
					<input type="text" class="form-control" 		id="usr">
						</div>
				</div> -->
				<!-- 작성일 : -->
 
		

	<div class="row">
		<div class="col-md-2 text-center">
			<button type="button" class="btn btn-primary" onclick="javascript:gotoList(${p})">목록가기</button>
		</div>
		<div class="col-md-9 text-right">
		<button type="submit" class="btn btn-info" id="article_update">확인</button>
		<button type="button" class="btn btn-warning" onclick="goBack()">취소</button>		
		</div>
	</div>
	
	</form>
  		</div>
		
		</div>
	</div>



<%-- 
<c:set var="context" value="${pageContext.request.contextPath}" />
<input type="hidden" id="context" value="${context}">
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
		<button type="button" class="btn btn-warning" onclick="javascript:gotoUpdateForm(${article.board_num }, ${cpageMap.currentPage })">수정</button>
		<button type="button" class="btn btn-danger">삭제</button>
	</div>
</div> --%>