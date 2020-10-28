<%@page import="kr.or.ddit.member.model.MemberVO"%>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
<%Cookie[] cookies = request.getCookies();
String mem_id = null;
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("mem_id")) {
		mem_id = cookie.getValue();
		request.setAttribute("mem_id", mem_id);
	}
}%>
	$("#updatepost").on("click", function() {
							var post_id = "${postVO.post_id }"
							location.href = "updatepost?post_id=" + post_id;
						});

						$("#deletepost").on("click", function() {
							var post_id = "${postVO.post_id}"
								var board_id = "${postVO.board_id }"
							location.href = "deletepost?post_id=" + post_id+"&board_id="+board_id;
						});

						$("#repostInsert").on(
								"click",
								function() {
									var post_id = "${postVO.post_id }"
									var gu = "${postVO.gu }"
									var board_id = "${postVO.board_id }"
									location.href = "repostInsert?post_id="
											+ post_id + "&gu=" + gu
											+ "&board_id=" + board_id;
								});

						$(".button1").on(
								"click",
								function() {
									var file_id = $(this).attr('name');
									location.href = "postfileDownload?file_id="
											+ file_id;
								});
						$("#regBtn").on("click", function() {
							$("#frm").submit();
						});

						$(".button2").on(
								"click",
								function() {
									var reply_id = $(this).attr('name');
									var post_id = "${postVO.post_id }"
									location.href = "deleteReply?reply_id="
											+ reply_id + "&post_id=" + post_id;
								});
					});
</script>
<style type="text/css">
#rd {
	margin-left: 200px;
}

#rt {
	border-spacing: 10px;
	border-collapse: separate;
}

#td1 {
	width: 500px;
}

.td2 {
	width: 80px;
}

th {
	font-size: 1.2em;
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

				<form class="form-horizontal" role="form">

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
							<label class="control-label">${postVO.post_id }</label>
						</div>
					</div>

					<div class="form-group" hidden="hidden">
						<label for="board_id" class="col-sm-2 control-label">게시판번호
							숨김</label>
						<div class="col-sm-10">
							<label class="control-label">${postVO.board_id }</label>
						</div>
					</div>
					<div class="form-group" hidden="hidden">
						<label for="gu" class="col-sm-2 control-label">게시글 구분 숨김</label>
						<div class="col-sm-10">
							<label class="control-label">${postVO.gu }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="post_title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${postVO.post_title }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="post_content" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label class="control-label">${postVO.post_content }</label>
						</div>
					</div>
					<c:forEach items="${fileList}" var="files">
						<div class="form-group">
							<label for="post_content" class="col-sm-2 control-label">첨부파일
								다운로드</label>
							<div class="col-sm-10">
								<button type="button" class="btn btn-default button1"
									name="${files.file_id}">다운로드:${files.file_realname}</button>
							</div>
						</div>
					</c:forEach>
					


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${postVO.mem_id eq mem_id}">
								<button type="button" class="btn btn-default" id="updatepost">수정</button>
								<button type="button" class="btn btn-default" id="deletepost">삭제</button>
							</c:if>
							<button type="button" class="btn btn-default" id="repostInsert">답글</button>
						</div>
					</div>
				</form>
				<hr>



				<form method="post" action="${cp}/replyinsert" id="frm">


					<div hidden="hidden">
						<input type="text" class="form-control" id="post_id"
							name="post_id" value="${postVO.post_id }" hidden="hidden">
					</div>
					<textarea id="rd" name="reply_content" rows="2" cols="100"></textarea>
					<button type="button" class="btn btn-default" id="regBtn">댓글작성</button>
				</form>


				<div id="rd">
					<table id="rt">
						<tr>
							<th>댓글</th>
							<th>작성자</th>
							<th>작성일자</th>
						</tr>
						
						<c:forEach items="${replyList}" var="reply">
						
						<c:if test="${reply.reply_status eq 0}">
							<tr id="${reply.reply_id }">
								<td id="td1">${reply.reply_content}</td>
								<td class="td2">${reply.mem_id}</td>
								<td class="td2"><fmt:formatDate value="${reply.reply_date}"
										pattern="yyyy-MM-dd" /></td>

								<c:if test="${reply.mem_id eq mem_id}">
									<td><button type="button" class="btn btn-default button2"
											name="${reply.reply_id}">삭제</button></td>
								</c:if>
								</tr>
						</c:if>
						<c:if test="${reply.reply_status eq 1}">
							<tr id="${reply.reply_id }">
								<td id="td1">삭제된 댓글입니다.</td>
							</tr>
						</c:if>
						</c:forEach>
						
						
						
						
						
						
						
					</table>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
