<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class=" row">
		
		<div class="panel panel-default">
		    <div class="panel-heading">게시글 쓰기</div>
		    <div class="panel-body">
		     
		      <form class="form-horizontal" role="form"  method="post" action="/bodymanager/board/writesave.do">
		      	<input type="hidden" name="board_num" value='<c:out value="${board_num }"/>'>
		      	<input type="hidden" name="ref_g" value='<c:out value="${ref_g}"/>'>
		      	<input type="hidden" name="re_step" value='<c:out value="${re_step }"/>'>
		      	<input type="hidden" name="re_level" value='<c:out value="${re_level }"/>'>
				<div class="form-group">
					<label for="subject" class="col-md-1 control-label">제목 </label> 
					 <div class="col-md-11">
					<input type="text" class="form-control"	id="subject" name="subject" placeholder="제목을 입력해 주세요">
					</div>
				</div>
				
				<div class="form-group">
					  <label for="category"  class="col-md-1 control-label" >카테고리 </label>
					   <div class="col-md-11">
					  <select class="form-control" id="category" name="category">
					    <option>1</option>
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
					<textarea class="form-control" rows="10"  name="content"></textarea>
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
			<button type="button" class="btn btn-primary" onclick="javascript:gotoList()">목록가기</button>
		</div>
		<div class="col-md-9 text-right">
		<button type="submit" class="btn btn-info" id="article_write">확인</button>
		<button type="button" class="btn btn-warning" onclick="goBack()">취소</button>		
		</div>
	</div>
	
	</form>
  		</div>
		
		</div>
	</div>
	

