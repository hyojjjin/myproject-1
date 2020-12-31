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
<%-- <link type="text/css" rel="stylesheet" href="${root }/font/loginFormFont.css"> --%>
<title>Insert title here</title>
</head>
<body>

	<u:topNavbar login="action" />
	<!--로그인 화면  -->


	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6 text-center mt-5 py-5 px-5"
				style="border: 1px solid lightgray; /* background-color: #eeeeeeff; */">
				<!-- //전체적으로 아래로 내리고 싶어 -->
				<!-- 	//밖에 큰 테두리를 두르고 싶어 -->
				<!-- 	//테두리 공간을 넓히고 싶어 -->
				<!-- 	//테두리 안쪽에 옅은 회색을 넣고싶어  -->


				<h3>로그인</h3>
				<!-- //가운데 정렬은 어떻게 하는 걸까? -->

				<form action="login.do" method="post">
					<div class="font mb-3">
						<input name="id" type="text" class="form-control" id="memberiw"
							placeholder="아이디를 입력해주세요.">
					</div>
					<div class="font mb-3">
						<input name="pw" type="password" class="form-control"
							id="memberpw" placeholder="비밀번호를 입력해주세요.">
					</div>

					<button type="submit" class="btn form-control"
						style="background-color: #134f5cff; color: white">로그인</button>

					<!-- //버튼 크기는 어떻게 하는 걸까? -->
					<!-- 	//버튼 색을 바꾸고싶어 style="background-color:#134f5cff; color:white" -->

					<br> <a href="join.do" class="float-right">회원 가입</a> <br>
					//float말고 다른 방법은 뭐가 있을까?

				</form>
			</div>
		</div>
	</div>

</body>
</html>