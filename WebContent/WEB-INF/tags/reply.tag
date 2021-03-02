<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="articleNo" type="java.lang.Integer" %>
<!-- 얜 머지 -->


<c:if test="${not empty sessionScope.authUser }">
<form action="${root }/reply/add.do" method="post">
<div class="container">
	<input type="number" value="${articleNo }" name="no" hidden />
	<input type="number" value="${param.pageNo }" name="pageNo"  hidden/>
	<input type="text" name="body">
	<button type="submit" class="btn form-control" style="background-color: #134f5cff; color: white">등록 </button>
</div>
</form>
</c:if>