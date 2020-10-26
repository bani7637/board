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

<%@ include file="/layout/commonLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
// 		$("#memList tr").on("click",function(){
// 			//data-userid
// 			var mem_id = $(this).data("userid");
// 			console.log("mem_id : "+mem_id);		
// 			location.href = "member?mem_id="+mem_id;
// 			});
		});
		 
	
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left_board.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header"></h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>게시글 제목</th>
									<th>게시글 작성자</th>
									<th>작성일시</th>
								</tr>
									<c:forEach items="${postList}" var="post">
											<td>${post.post_id}</td>
											<td>${post.post_title}</td>
											<td>${post.mem_id}</td>
											<td><fmt:formatDate value="${post.post_date}" pattern="yyyy-MM-dd" /></td>
									</c:forEach>
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
