<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<jsp:include page="../common/adminHeader.jsp"/>
	<div class="wrap">
		<div class="innerwrap">
			<button type="button" onclick="location.href='${pageContext.servletContext.contextPath}/regist/post/room'"> 객실 등록 </button>
		</div>
	</div>
	<jsp:include page="../common/adminFooter.jsp"/>
</body>
</html>