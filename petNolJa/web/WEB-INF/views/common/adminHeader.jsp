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
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/contents.css">
<!-- icon -->
<script src="https://kit.fontawesome.com/9d883380b6.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<header>
		<div class="hedader_main">
	     <div class="header_middle" style="padding-top: 25px;">
			<h1 style="font-size: 30px;">
				<a href="${ pageContext.servletContext.contextPath }/admin/main">Petnolja</a>
	         </h1>
	     </div>
	    </div>
	</header>
	<nav style=" position:absolute; width: 300px; bottom:0%; float: left; height: 90%;">
		<section id="navSection" >
			<aside id="pix-nav" >
				<div class="info">
					<div id="admin-member" align="center">
						<br>
						<h4><c:out value="${sessionScope.loginEmp.empName}"/>님</h4>
						<br>
						<p><a href="${pageContext.servletContext.contextPath}/common/logout" style="font-size: 13px;">로그아웃</a></p>
						<br>
					</div>
				</div>
			</aside>
			<div id="admin-menu">
				<section align="center">
					<ul>
						<li class="m01">
							<a class="m01_b" href="#">인사 관리</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="#">직원 관리</a></li>
									<li class="subhas"><a href="#">전자 결재</a></li>
									<li class="subhas"><a href="#">출근부 확인</a></li>
									<li class="subhas"><a href="#">부서 관리</a></li>
									<li class="subhas"><a href="#">직책 관리</a></li>
								</ul>
							</div>
						</li>
						<li class="m01">
							<a class="m01_b" href="#">회원 관리</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="#">회원 정보 조회</a></li>
									<li class="subhas"><a href="#">휴먼 회원 관리</a></li>
									<li class="subhas"><a href="#">탈퇴 회원 관리</a></li>
								</ul>
							</div>
						</li>
						<li class="m01">
							<a class="m01_b" href="#">예약 관리</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="#">예약 조회</a></li>
								</ul>
							</div>
						</li>
						<li class="m01">
							<a class="m01_b" href="#">게시물 관리</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="${pageContext.servletContext.contextPath}/select/post/room/list">객실 게시물 관리</a></li>
									<li class="subhas"><a href="${pageContext.servletContext.contextPath}/select/post/petsitter/list">펫시터 게시물 관리</a></li>
								</ul>
							</div>
						</li>
						<li class="m01">
							<a class="m01_b" href="#">고객센터</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="#">공지사항 관리</a></li>
									<li class="subhas"><a href="#">FAQ 관리</a></li>
									<li class="subhas"><a href="#">1:1 문의글 관리</a></li>
								</ul>
							</div>
						</li>
						<li class="m01">
							<a class="m01_b" href="#">호텔 관리</a>
							<div class="sub_wrap">
								<ul>
									<li class="subhas"><a href="#">회사 소개 관리</a></li>
									<li class="subhas"><a href="#">위치 안내 관리</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</section>
			</div>
		</section>
	</nav>
	<div class="line"></div>
<script>
	/* 관리자 메인 메뉴 */
	$('.m01_b').click(function(){
		$('.sub_wrap').slideUp();
		
		if($(this).hasClass('active') == false){       
		    $(this).siblings('.sub_wrap').slideDown(500);
		    $(this).addClass('active'); 
		    $(this).parent('li').addClass('on');  
		} else  {
		    $(this).siblings('.sub_wrap').slideUp(200);
		    $(this).removeClass('active'); 
		    $(this).parent('li').removeClass('on'); 
		}
	});
</script>
</body>
</html>