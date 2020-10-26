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
<script type="text/javascript">
	$(document).ready(function(){
		$("#memList tr").on("click",function(){
			//data-userid
			var mem_id = $(this).data("userid");
			console.log("mem_id : "+mem_id);		
			location.href = "member?mem_id="+mem_id;
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


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
								</tr>
								<tbody id="memList">
									<%
										request.getAttribute("memList");
									%>
									<c:forEach items="${memList}" var="member">
										<tr data-userid="${member.mem_id}">
											<td>${member.mem_id}</td>
											<td>${member.mem_name}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<a class="btn btn-default pull-right" href="${pageContext.request.contextPath }/memberRegist">사용자 등록</a>
						
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
