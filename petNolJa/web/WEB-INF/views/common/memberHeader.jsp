<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/basic.css">
<!-- icon -->
<script src="https://kit.fontawesome.com/9d883380b6.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>펫놀자</title>

<style>
	body::-webkit-scrollbar {
    	width: 8px;  /* 스크롤바의 너비 */
	}
	
	body::-webkit-scrollbar-thumb {
	    height: 30%; /* 스크롤바의 길이 */
	    background: #73645D;  /* 스크롤바의 색상 */
	    border-radius: 10px;
	}
	
	body::-webkit-scrollbar-track {
	    background: rgb(243, 242, 242);  /*스크롤바 뒷 배경 색상*/
	}
</style>
</head>
<body>
	<div id="header_wrap">
        <header>
            <div class="header_top">
                <ul class="top_member_box">
                	<c:if test="${empty sessionScope.loginMember and empty sessionScope.loginEmp}">
                    	<li><a href="${pageContext.servletContext.contextPath}/common/login">로그인</a></li>
                    	<li><a href="${pageContext.servletContext.contextPath}/member/regist/agree">회원가입</a></li>
                   	</c:if>
                   	<c:if test="${!empty sessionScope.loginMember or !empty sessionScope.loginEmp}">
                    	<li><a href="${pageContext.servletContext.contextPath}/common/logout">로그아웃</a></li>
                    	<li><a href="#">호텔예약</a></li>
                    	<li><a href="#">마이페이지</a></li>
                   	</c:if>
                    <li><a href="#">고객센터</a></li>
                </ul>
            </div>
            <div class="header_main">
	            <div class="header_middle" style="margin-bottom: 20px;">
	            	<div class="gnb_all">
                    	<input type="checkbox" id="hamB"> <label for="hamB" class="hamB_la"><span></span><span></span><span></span></label>
	                </div>
	                <h1 style="font-size: 30px;">
	                    <a href="${ pageContext.request.contextPath }/index.jsp">Petnolja</a>
	                </h1>
	            </div>
                
                <div class="right_btn">
                    <ul>
                        <li><a href="#">님 환영합니다.</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/common/login">login</a></li>
                    </ul>
                </div>
               <div class="gnb">
					<ul class="depth0">
						<li><a href="#">ROOM</a></li>
				 		<li><a href="#">PET SITTER</a></li>
						<li><a href="#">LOCATION</a></li> 
                   		<li><a href="#">COMPANY</a></li>
						<li><a href="#">CUSTOMER CENTER</a></li>
						<li><a href="#">REVIEW</a></li>
					</ul>
				</div>
            </div>
        </header>
    </div>
</body>
</html>