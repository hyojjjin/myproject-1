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
	<u:topNavbar join="active" />



	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6 mt-5 py-5 px-5" style="border: 1px solid lightgray">
				<h3 class="text-center">회원 가입</h3>

				<form action="join.do" method="post">
					<div class="mb-3" >
						<label for="memberid" class="form-label">아이디</label> <input
							type="text" class="form-control" id="memberid" name="memberid"
							value="${param.memberid }">

						<c:if test="${errors.memberid }">
							<small class="form-text" style="color: tomato"> 아이디를
								입력해주세요. </small>
						</c:if>


						<c:if test="${errors.duplicateId }">
							<small class="form-text" style="color: tomato""> 중복된
								아이디입니다. </small>
						</c:if>

					</div>
					
					<div class="mb-3">
						<label for="memberpw" class="form-label">비밀번호</label> <input
							type="password" class="form-control" id="memberpw"
							name="memberpw" value="${param.memberpw }">
					</div>
					
						<c:if test="${errors.memberpw }">
							<small class="form-text" style="color: tomato"> 비밀번호를
								입력해주세요. </small>
						</c:if>
						
					<div class="mb-3">
						<label for="memberpwConfirm" class="form-label">비밀번호 확인</label> <input
							type="password" class="form-control" id="memberpwConfirm"
							name="memberpwConfirm" value="${param.memberpwConfirm }">

						<c:if test="${errors.memberpwConfirm }">
							<small class="form-text" style="color: tomato"> 비밀번호 확인을 입력해주세요.</small>
						</c:if>

						<c:if test="${errors.pwNotMatch }">
							<small class="form-text" style="color: tomato"> 비밀번호가 일치하지 않습니다. </small>
						</c:if>
					</div>
					
					<div class="mb-3">
						<label for="name" class="form-label">이름</label> <input type="text"
							class="form-control" id="name" name="name" value="${param.name }">
						<c:if test="${errors.name }">
							<small class="form-text" style="color: tomato"> 이름을 입력해주세요.</small>
						</c:if>
							
					</div>
					<div class="mb-3">
						<label for="nickname" class="form-label">닉네임</label> <input
							type="text" class="form-control" id="nickname" name="nickname"
							value="${param.nickname }">
							
						<c:if test="${errors.nickname }">
							<small class="form-text" style="color: tomato"> 닉네임을 입력해주세요.</small>
						</c:if>

						<c:if test="${errors.duplicateNn }">
							<small class="form-text" style="color: tomato"> 중복된 닉네임입니다. </small>
						</c:if>
					</div>

					<button type="submit" class="btn form-control" style="background-color: #134f5cff; color: white">회원 가입</button>
				</form>

			</div>
		</div>
	</div>

</body>
</html>