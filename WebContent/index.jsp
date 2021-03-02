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
#carouselExampleCaptions {
	width:100%;
	hight:10px;
}

</style>
<!-- #jumbotron1 {
	position: absolute;
	left: 0;
	bottom: 450px;
	width: 100%;
} -->


<title>Insert title here</title>
</head>
<body>
<%-- <div>
${pageContext.request.servletContext.contextPath }
</div>
<div>
${pageContext.request.contextPath }
</div> --%>
<!--
	1. 홈 화면
	1> navbar
	2> 이미지 구역
	3> 게시판 구역
	  --> 

<!--상단 navbar 삽입  -->

	<u:topNavbar home="active" />


	<div class="jumbotron">
		<h4 class="">[김효진] 개인프로젝트-1</h4>
		<h6 class="font-weight-nomal"> 2020년 12월, 정말 춥당. 1월이 더 춥다,,</h6>
		<hr class="my-4">
		<p class="font-weight-light">안녕하세요. 반갑습니다. 저의 첫번째 개인 프로젝트입니다. 부트스트랩을 이용하여 정말정말 간단한 페이지를 만들었습니다.
							할 수 있는 기능은 몇 개 없지만 글이 영원히 보존되는 게시판을 경험해보세요. 회원가입부터 시작하세요!</p>
	</div>




	<!--메인 이미지 구역  -->
	<div id="carouselExampleCaptions" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="${root }/img/main/img_1_paris.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>First slide label</h5>
					<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="${root }/img/main/img_2_dog.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Second slide label</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="${root }/img/main/img_3_cap.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Third slide label</h5>
					<p>Praesent commodo cursus magna, vel scelerisque nisl
						consectetur.</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleCaptions"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>







	<%-- 	<div id="carouselExampleIndicators" >
	
			<div class="carousel-item active">
				<img src="${root }/img/main/paris_1.png" class="d-block w-100"
					alt="paris_1">
			</div>
			
		<div id="jumbotron1">
			<div class="container">
				<h2 class="text-white">[김효진] 개인 프로젝트 1</h2>
				<h4 class="text-light">첫번째 개인 프로젝트입니다. 부트스트랩을 이용하여 정말정말 간단한
					페이지를 만들었습니다.
					<br> 할 수 있는 기능은 몇 개 없지만 회원 가입을 한 뒤 글이 영원히 보존되는 게시판을 경험해보세요.
					</h4>
			</div>
		</div>
	</div> --%>
	
			<div class="clearfix"></div>
	
<!-- 	jumbotron-fluid bg-dark -->


		<!-- 프레임 안에
번호, 제목, 닉네임, 시간  -->


		<!-- 몰랑  -->


	<u:bottomNavbar />

</body>
</html>