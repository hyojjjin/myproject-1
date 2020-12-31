<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<div class="container mt-5">
		<div class="jumbotron bg-white border">
			<h4>${articleData.article.title }</h4>

			<small class="text-muted">작성자 ${articleData.article.writerNickname }
				| 작성일 ${articleData.article.regdate } | 조회수
				${articleData.article.readCnt + 1} | 댓글수</small> 
			<hr class="my-4">
			<p>${articleData.content.content }</p>
		</div>
		<a class="btn btn-primary btn-sm" href="${root }/list.do"
			role="button">다음글 </a>
		<a class="btn btn-primary btn-sm" href="${root }/list.do"
			role="button">삭제 </a>
		<a class="btn btn-primary btn-sm" href="${root }/list.do" 
			role="button">수정 </a>
		<a class="btn btn-primary btn-sm" href="${root }/list.do"
			role="button">목록 </a>
	</div>

</body>
</html>