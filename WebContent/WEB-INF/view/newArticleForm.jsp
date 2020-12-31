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


<style>
#title {
font-size:20px;
}
</style>

<title>Insert title here</title>
</head>
<body>

	<u:topNavbar />
	<div class="col-3"></div>
	<div class="col-6 mt-5 text-conter">
		<div class="container">
			<form action="write.do" method="post">

				<h3>영원히 남아있는 글쓰기</h3>


				<div class="jumbotron bg-white border">
					<input style="border:none;" type="text" name="title" placeholder="제목을 입력해주세요."
						value="${param.title }" id="title" />

					<hr class="my-4">
					<textarea style="border:none;" name="content" placeholder="내용을 입력해주세요."
						value="${param.content }"></textarea>


				</div>

				<button type="submit" class="btn"
					style="background-color: #0b5394ff; color: white">등록</button>
			
				<a href="${root }/list.do">
					<button type="submit" class="btn"
						style="background-color: #0b5394ff; color: white">글목록</button>
				</a>
			</form>
		</div>
	</div>



	<!-- 		<input type="text" name="title" placeholder="제목을 입력해주세요." /> <br />

		<textarea name="content" placeholder="내용을 입력해주세요."></textarea>


		<br /> <input type="submit" value="등록" />
		</form>
	</div>
	</div>  -->
			

</body>
</html>