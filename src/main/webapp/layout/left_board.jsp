<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

				<ul class="nav nav-sidebar">
					<li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Main <span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="${pageContext.request.contextPath}">게시판</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/boardAllList">게시판 관리</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/board/insertboard.jsp">게시판 만들기</a></li>
<%-- 					<c:forEach items="${boardList}" var="board"> --%>
<%-- 						<li class="active"><a href="#">${board.board_name}</a></li> --%>
<%-- 					</c:forEach> --%>
				</ul>
