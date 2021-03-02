<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
	<c:forEach items="${replylist}" var="reply">
		<!-- //어디서 꺼내오는 거야?? -->
		<!-- readhandler에서 꺼내옴 -->

		
			
				<input type="text" for="reply" readonly value ="${reply.nickname }" >
				<input type="text" readonly id="reply" value="내용">
		
		//데이터는 왜 안꺼내져????? 휴!

	</c:forEach>

</div>