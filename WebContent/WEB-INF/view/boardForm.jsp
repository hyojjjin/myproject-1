<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
	  <%
	  String pageStr = request.getParameter("pageNo");
	  int pageNo = 1;
	  if (pageStr != null) {
		  pageNo = Integer.parseInt(pageStr);
	  }
	  pageContext.setAttribute("pageNo", pageNo);
	  %>
<!--상단 navbar 삽입  -->

	<u:topNavbar board="active" />


	<div class="col-12">
		<div class="container text-conter">
			<h3>나는 삭제를 모르는 게시판</h3>

			<table class="table table-striped">
				<thead style="background-color: #0b5394ff; color: white">
					<tr>
						<th scope="col">index</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="article" items="${articlePage.content }"
						varStatus="status">

						<tr>
							<td scope="row">${(pageNo-1) * 10 + status.index +1 }</td>
							<td class="position-relative"><a
								href="${root }/read.do?no=${article.number }&pageNo=${articlePage.currentPage }">
									<c:out value="${article.title }" />
							</a></td>
							<td>${article.writerNickname}</td>
							<td>${article.readCnt}</td>
							<td>${article.regdate}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<a href="${root }/write.do">
				<button type="submit" class="btn"
					style="background-color: #0b5394ff; color: white">글쓰기</button>

			</a>
		</div>
	</div>

	<!--페이지  -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<c:if test="${articlePage.startPage > 5 }">
				<li class="page-item"><a class="page-link"
					href="${root }/list.do?pageNo=1"
					style="background-color: #0b5394ff; color: white">처음</a></li>
			</c:if>

			<c:if test="${articlePage.startPage > 5 }">
				<li class="page-item"><a class="page-link"
					href="${root }/list.do?pageNo=${articlePage.startPage - 5 }"
					style="background-color: #0b5394ff; color: white">이전</a></li>
			</c:if>

			<c:forEach begin="${articlePage.startPage }"
				end="${articlePage.endPage }" var="pNo">
				<li class="page-item"><a class="page-link"
					href="${root }/list.do?pageNo=${pNo }">${pNo }</a></li>
			</c:forEach>

			<c:if test="${articlePage.totalPages > articlePage.endPage }">
				<li class="page-item "><a class="page-link"
					href="${root }/list.do?pageNo=${articlePage.startPage + 5 }"
					style="background-color: #0b5394ff; color: white">다음</a></li>
			</c:if>

			<c:if test="${articlePage.endPage ne articlePage.totalPages }">
				<li class="page-item "><a class="page-link"
					href="${root }/list.do?pageNo=${articlePage.totalPages }"
					style="background-color: #0b5394ff; color: white">맨끝</a></li>
			</c:if>

		</ul>
	</nav>
	
