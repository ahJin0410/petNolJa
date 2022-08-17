<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/admin.css">
<!-- icon -->
<script src="https://kit.fontawesome.com/9d883380b6.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
    body::-webkit-scrollbar {
    	width: 8px;  /* 스크롤바의 너비 */
	}
	
	body::-webkit-scrollbar-thumb {
	    height: 30%; /* 스크롤바의 길이 */
	    background: #000000;  /* 스크롤바의 색상 */
	    border-radius: 10px;
	}
	
	body::-webkit-scrollbar-track {
	    background: rgb(243, 242, 242);  /*스크롤바 뒷 배경 색상*/
	}
	.line{
		background: black;
		color: white;
	}
	
</style>
</head>
<body>
	<header>
		<div class="hedader_main">
	     <div class="header_middle" style="margin-top: 25px;">
			<h1 style="font-size: 30px;">
				<a href="${ pageContext.servletContext.contextPath }/admin/main">Petnolja</a>
	         </h1>
	     </div>
	    </div>
	</header>
	<nav>
		<section id="body" style="width: 1500px;">
			<aside id="pix-nav">
				<div class="line">
					<div id="admin-member" align="center">
						<br>
						<h4><c:out value="${sessionScope.loginEmp.empName}"/>님</h4>
						<br>
						<p><a href="${pageContext.servletContext.contextPath}/common/logout" style="font-size: 13px;">로그아웃</a></p>
						<br>
					</div>
				</div>
			</aside>
		</section>
	</nav>
</body>
</html>