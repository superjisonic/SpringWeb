<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="../include/header.jsp" %>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->
        <div class="box box-primary">
        <div class="box-header">
          <h3 class="box-title">READ BOARD</h3>
        </div><!-- /.box-header -->
 
  <div class="box-body">
    <div class="form-group">
      <label for="exampleInputEmail1">Title</label>
      <input type="text" name='title' class="form-control" 
         value="${board.title}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Content</label>
      <textarea class="form-control"  name="content" rows="3" 
      readonly="readonly">${board.content}</textarea>
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1" >Writer</label>
      <input type="text" name="writer" class="form-control" 
        value="${board.writer}" readonly="readonly">
    </div>
  </div><!-- /.box-body -->

  <div class="box-footer">
	<c:if test="${ loginUser.name == board.writer }">
	<button id="modify" type="button" class="btn btn-warning">Modify</button> 
	<button id="remove" type="button" class="btn btn-danger">REMOVE</button> 
    </c:if>
    <button id="list" type="button" class="btn btn-primary">GO LIST </button>
  </div>
  
  <div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">Writer</label> 
					<input class="form-control" type="text" placeholder="USER ID"    id="newReplyWriter"> 
					<label for="exampleInputEmail1">Reply Text</label> 
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">

				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</div>
			</div>

		
		<!-- The time line -->
		<ul class="timeline">
		  	<!-- timeline time label -->
			<li class="time-label" id="repliesDiv">
			  <span class="bg-green">
			    Replies List <small id='replycntSmall'> [ 000 ] </small>
			  </span>
			</li>
		</ul>
		<!--  
		<ul id="rlist">
				<c:forEach items="${board.rlist}" var="reply">
					
					<li class="time-label">${reply.rcontent}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:removeReply(${reply.rseq},${reply.bno})">X</a>
					</li>
				</c:forEach>
		</ul>
		 -->   
			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->


<script>


	$(document).ready(function() {
		$("#list").click(function() {
			location.href="listPage.sinc" ; 
		});
		$("#remove").click(function() {
			location.href="removePage.sinc?seq="+${board.seq} ; 
		});
		$("#modify").click(function() {
			location.href="modifyPage.sinc?seq="+${board.seq} ; 
		});	

	});


</script>


  
  
        </div>
      </div>
 
      </div>
    </section>
    </div>
    
<%@include file="../include/footer.jsp" %>
  