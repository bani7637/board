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

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<%@ include file="/layout/commonLib.jsp"%>

</head>

<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
							<ul class="nav nav-sidebar">
					<li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Main <span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/board/insertboard.jsp">게시판 만들기</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/boardAllList">게시판 관리</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/boardList">게시판List</a></li>
					<c:forEach items="${boardList}" var="board">
						<li ><a href="${cp}/selectPost?board_id=${board.board_id}">${board.board_name}</a></li>
					</c:forEach>
				</ul>
			
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h3>게시판 수정</h3><hr>
					<c:forEach items="${boardList2}" var="boardVO">
				<form class="form-horizontal" role="form" id="${boardVO.board_id }"
					action="${cp}/updateBoard" method="post">
								<input type="hidden" class="form-control" id="board_id"
									name="board_id" value="${boardVO.board_id }" >
						<div class="form-group">
							<label for="board_name" class="col-sm-2 control-label">게시판
								이름</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="board_name"
									name="board_name" value="${boardVO.board_name }">
							</div>
						</div>
						<div class="form-group">
							<label for="board_status" class="col-sm-2 control-label">게시판
								사용여부</label>
							<div class="col-sm-10">

								<select id="board_status" name="board_status">
									<option value="0"
										<c:if test="${boardVO.board_status == 0}">selected</c:if>>사용
									</option>
									<option value="1"
										<c:if test="${boardVO.board_status == 1}">selected</c:if>>사용
										안함</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default" id="${boardVO.board_id }">게시판
									수정</button>
							</div>
						</div>
						<br>
						<br>
				</form>
						</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
