<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag dynamic-attributes="map" %>

<nav>
<!-- //있을떄 -->
		<c:if test="${not empty sessionScope.authUser }">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8 text-right">
				<a class="btn"
						href="delete.do">회원 탈퇴</a>
			</div>
		</div>
		</c:if>
</nav>