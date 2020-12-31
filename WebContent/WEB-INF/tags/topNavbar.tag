<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag dynamic-attributes="map" %>
<!--
 1> 기본 navbar 만들기
	-홈 버튼
	-게시판 버튼
	-회원가입 버튼
	-로그인 버튼
	-->



<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="index.jsp"> <i
		class="fas fa-snowflake"></i></a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item ${map.home }"><a class="nav-link" href="index.jsp">Home</a>
			</li>

			<li class="nav-item ${map.board }"><a class="nav-link" href="list.do">게시판</a>
			</li>
			
		</ul>

		<!-- //없을떄 -->
		<c:if test="${empty sessionScope.authUser }">
			<ul class="navbar-nav">
				<li class="nav-item ${map.join }"><a class="nav-link"
					href="join.do">회원가입</a></li>

				<li class="nav-item ${map.login }"><a class="nav-link"
					href="login.do">로그인</a></li>

			</ul>
		</c:if>


		<!-- //있을떄 -->
		<c:if test="${not empty sessionScope.authUser }">
			<ul class="navbar-nav">				
				<li class="nav-item ${map.home}"><a class="nav-link"
					href="join.do">${sessionScope.authUser.name }님</a></li>

				<li class="nav-item ${map.logout }"><a class="nav-link"
					href="logout.do">로그아웃</a></li>

			</ul>
		</c:if>

	</div>
</nav>

