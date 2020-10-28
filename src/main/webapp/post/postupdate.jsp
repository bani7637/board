<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp"%>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
	$(document).ready(function() {
		$('#summernote').summernote();

		$(".button2").on(
				"click",
				function() {
					var file_id = $(this).attr('name');
					var post_id = "${postVO.post_id }";
					location.href = "deletefile?file_id="+ file_id+"&post_id="+post_id;
				});
		
		$("#regBtn").on("click", function() {
			$("#frm").submit();
		});
	});
</script>
<style type="text/css">
#dd{
margin-top:100px; 
}
</style>
</head>

<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div id="dd"></div>
				<form class="form-horizontal" role="form" id="frm"
					action="${cp}/updatepost" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="post_date" class="col-sm-2 control-label">작성일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate
									value="${postVO.post_date}" pattern="yyyy-MM-dd" /></label>
						</div>
					</div>

					<div class="form-group">
						<label for="mem_id" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${postVO.mem_id }</label>
						</div>
					</div>



					<div class="form-group" hidden="hidden">
						<label for="post_id" class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="post_id"
								name="post_id" value="${postVO.post_id }">
						</div>
					</div>
					
					
					

					<div class="form-group" hidden="hidden">
						<label for="board_id" class="col-sm-2 control-label">게시판
							번호 숨김</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="board_id"
								name="board_id" value="${postVO.board_id }">
						</div>
					</div>

					<div class="form-group">
						<label for="post_title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="post_title"
								name="post_title" value="${postVO.post_title }">
						</div>
					</div>
					


					<input type="text" id="board_id" name="board_id" hidden="hidden"
						value="${board_id}"></input>
						
					<textarea id="summernote" name="post_content">
					${postVO.post_content }
					</textarea>



					<div>
					<c:forEach items="${fileList}" var="files">
						<div>
							${files.file_realname }<button type="button" class="btn btn-default button2" name="${files.file_id }">삭제</button>
						</div>
						</c:forEach>
					</div>
					<div>
					<c:if test="${fileListSize eq 0}">
						<input type="file" id="realFilename1" name="realFilename1">첨부파일1
							<input type="file" id="realFilename2" name="realFilename2">첨부파일2
							<input type="file" id="realFilename3" name="realFilename3">첨부파일3
							<input type="file" id="realFilename4" name="realFilename4">첨부파일4
							<input type="file" id="realFilename5" name="realFilename5">첨부파일5
					
					</c:if>
					<c:if test="${fileListSize eq 1}">
						<input type="file" id="realFilename1" name="realFilename1">첨부파일1
							<input type="file" id="realFilename2" name="realFilename2">첨부파일2
							<input type="file" id="realFilename3" name="realFilename3">첨부파일3
							<input type="file" id="realFilename4" name="realFilename4">첨부파일4
					
					</c:if>
					<c:if test="${fileListSize eq 2}">
						<input type="file" id="realFilename1" name="realFilename1">첨부파일1
							<input type="file" id="realFilename2" name="realFilename2">첨부파일2
							<input type="file" id="realFilename3" name="realFilename3">첨부파일3
					
					</c:if>
					<c:if test="${fileListSize eq 3}">
						<input type="file" id="realFilename1" name="realFilename1">첨부파일1
							<input type="file" id="realFilename2" name="realFilename2">첨부파일2
					
					</c:if>
					<c:if test="${fileListSize eq 4}">
						<input type="file" id="realFilename1" name="realFilename1">첨부파일1
							<input type="file" id="realFilename2" name="realFilename2">첨부파일2
					
					</c:if>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="regBtn">수정하기</button>
						</div>
					</div>
					</div>
				</form>


			</div>
		</div>
	</div>
</body>
</html>
