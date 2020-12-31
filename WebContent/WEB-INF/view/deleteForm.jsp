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

	<u:topNavbar delete="action" />

	<h3>회원탈퇴</h3>

	<form action="delete.do" method="post">
		<div class="mb-3">
			<label for="memberid" class="form-label">아이디</label> <input
				type="text" class="form-control" id="memberid" name="memberid"
				placeholder="아이디를 적어주세요.">

			<c:if test="${errors.MemberNotFound }">
				<small class="form-text" style="color: tomato"> 아이디를 확인해주세요.
				</small>
			</c:if>

			<c:if test="${errors.emptyid }">
				<small class="form-text" style="color: tomato"> 아이디를 적어주세요.
				</small>
			</c:if>
		</div>


		<div class="mb-3">
			<label for="memberpw" class="form-label">비밀번호</label> <input
				type="password" class="form-control" id="memberpw" name="memberpw"
				placeholder="비밀번호를 적어주세요.">
			<c:if test="${errors.InvalidPw }">
				<small class="form-text" style="color: tomato"> 비밀번호가
					맞지않습니다. </small>
			</c:if>


			<c:if test="${errors.emptypw }">
				<small class="form-text" style="color: tomato"> 비밀번호를 적어주세요.
				</small>
			</c:if>
		</div>


		<button type="submit" class="btn btn-primary">회원 탈퇴</button>









		<%-- 	<c:if test="${errors.emptyid && }">
		</c:if> --%>

	</form>

</body>
</html>