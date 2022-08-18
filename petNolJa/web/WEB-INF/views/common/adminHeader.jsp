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
	.info{
		background: black;
		color: white;
		padding-top: 20px;
	}
	
	/*서브메뉴*/
	 .m01{margin:10px 0;}
	 .m01 > a {line-height: 45px;}
	 .sub_wrap {  /* position:absolute; */ width: 100%; left:0; right:0; height:265px; 
	 padding:0 0 30px 0;color:#f1efec;   }
   
    .sub_wrap > ul > li { margin: 0 auto; width:100%; margin-top:24px; }
    .sub_wrap > ul > li > a { font-size:15px; line-height:33px; color:  #0b1c2c; }

    /*서브들 전부*/   
    .sub_wrap .floatX { clear:both; }  
    .sub_wrap .subUp { margin-left:-240px; margin-top:130px; }

    .subhas a { font-size:13px; line-height:30px; color:  #0b1c2c; }

    /*서브메뉴-2*/
    .sub_wrap {display: none; position:relative; top:0px; margin: 0 auto; width: 100%; height:auto; padding:0 0 0 0;  }
    .sub_wrap > ul { position:relative; width:300px; }
    .sub_wrap > ul > li { float:none; width:auto; margin-top:0;  border-top:1px solid #ccc;}
    .sub_wrap > ul > li > a { font-size:14px; line-height:37px; }
    .sub_wrap > ul > li > a:hover { color: #959595;}

	.line { position:absolute; top: 102px; bottom:0%; left:300px; width:0.7px; height:90%; background:black; }
	
    .sub_wrap > ul > li.subhas { padding-left:0;  }

    .subhas ul { display:none; background:#ebe9e9; padding-left:20px;  border-top:1px solid #ccc;}
    .subhas > a {  position:relative; display:block; padding-left:20px;}

    .subhas > ul > li > a { font-size:13px; line-height:26px; }
</style>
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
	<nav>
		<section id="navSection" style="width: 300px;">
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
									<li class="subhas"><a href="#">객실 게시물 관리</a></li>
									<li class="subhas"><a href="#">펫시터 게시물 관리</a></li>
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
</body>
</html>