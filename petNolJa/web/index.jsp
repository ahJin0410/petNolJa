<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫놀자</title>
</head>
<body>
	<!-- 고객 메인페이지 -->
	<jsp:forward page="/WEB-INF/views/main/memberMain.jsp"/>
	
	<!-- 관리자 메인페이지 -->
	<jsp:forward page="/WEB-INF/views/main/adminMain.jsp"/>
</body>
</html>