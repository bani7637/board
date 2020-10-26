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

<script>
	$(document).ready(function() {
		
		$("#regBtn").on("click",function(){
				$("#frm").submit();
		});
	});

</script>
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
				</ul>
			
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h3>게시판 만들기</h3><hr>
				<form class="form-horizontal" role="form" id="frm" action="${cp}/insertBoard" method="post">
					<div class="form-group">
						<label for="board_name" class="col-sm-2 control-label">게시판 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="board_name" name="board_name"
								placeholder="게시판이름을 작성하세요">
						</div>
					</div>
					<div class="form-group">
						<label for="board_name" class="col-sm-2 control-label">게시판 사용여부</label>
						<div class="col-sm-10">
							<select id="board_status" name="board_status">
									<option value="0">사용</option>
									<option value="1">사용 안함</option>
								</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="regBtn">게시판 등록</button>
						</div>
					</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>
