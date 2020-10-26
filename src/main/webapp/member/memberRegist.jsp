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
		//client side - validation
		//server side - validation
		//두개다 해줘야 안전함 일단생략 스프링수업때할예정
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
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" id="frm" action="${cp}/memberRegist" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="mem_id" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mem_id" name="mem_id"
								placeholder="사용할 아이디를 입력하세요">
						</div>
					</div>

					<div class="form-group">
						<label for="mem_name" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mem_name" name="mem_name"
								placeholder="이름을 입력하세요" value="${param.mem_name }">
						</div>
					</div>

					<div class="form-group">
						<label for="mem_name" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mem_pass" name="mem_pass"
								placeholder="비밀번호를 입력하세요" value="${param.mem_pass }">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="regBtn">사용자 등록</button>
						</div>
					</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>
