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
	$(document).ready(function() {
		$("#postList tr").on("click", function() {
			var post_id = $(this).data("postid");
			var poststatus = $(this).data("poststatus");

			if (poststatus == 0) {
				console.log("postid : " + post_id);
				location.href = "post?post_id=" + post_id;
			}
			if (poststatus == 1) {
				alert("삭제된 게시글 입니다.");
			}

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
						<h2 class="sub-header">${board_name}</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>게시글 제목</th>
									<th>게시글 작성자</th>
									<th>작성일시</th>
								</tr>
								<tbody id="postList">
									<c:forEach items="${postList}" var="post">
									
										<tr data-postid="${post.post_id}"
											data-poststatus="${post.post_status}">
											<td>${post.post_id}</td>

											<c:if test="${post.p_post_id eq 0 && post.post_status eq 0}">
												<td>${post.post_title}</td>
											</c:if>

											<c:if test="${post.p_post_id eq 0 && post.post_status eq 1}">
												<td>삭제된 게시글 입니다.</td>
											</c:if>


											<c:if test="${post.level eq 2 && post.post_status eq 0}">
												<td style="padding-left: 30px;">➜ ${post.post_title}</td>
											</c:if>
											
											<c:if test="${post.level eq 3 && post.post_status eq 0}">
												<td style="padding-left: 60px;">➜ ${post.post_title}</td>
											</c:if>
											

											<c:if test="${post.p_post_id ne 0 && post.post_status eq 1}">
												<td style="padding-left: 20px;">➜ 삭제된 답글입니다.</td>
											</c:if>

											<td>${post.mem_id}</td>
											<td><fmt:formatDate value="${post.post_date}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<a class="btn btn-default pull-right"
							href="${pageContext.request.contextPath }/insertPost?board_id=${board_id}">글쓰기</a>
						<div class="text-center">
							<ul class="pagination">

								<c:if test="${page ne 1}">
									<li ><a href="${pageContext.request.contextPath }/selectPost?board_id=${board_id}&page=1">&#60;&#60;</a></li>
									<li ><a href="${pageContext.request.contextPath }/selectPost?board_id=${board_id}&page=${page-1 }">&#60;</a></li>
								</c:if>
								<c:forEach begin="1" end="${pages }" var="i">
									<c:choose>
										<c:when test="${i == page}">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${pageContext.request.contextPath }/selectPost?board_id=${board_id}&page=${i}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${page ne pages && pages ne 0}">
									<li ><a href="${pageContext.request.contextPath }/selectPost?board_id=${board_id}&page=${page+1}">&#62;</a></li>
									<li ><a href="${pageContext.request.contextPath }/selectPost?board_id=${board_id}&page=${pages }">&#62;&#62;</a></li>
								</c:if>
							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
