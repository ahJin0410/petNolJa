<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫놀자</title>
</head>
<body>
	<jsp:include page="../../common/memberHeader.jsp"/>
	
	<div align="center">
        <div class="innerwrap">
            <h2>회원 가입 완료</h2>
            <p id="order" style="padding-bottom: 40px;">① 약관동의 - ② 회원 정보 입력 - <b class="text-deco">③ 가입 완료</b> </p>
            <br>
	        <hr>
	        <br><br>
			<div id="message">
				<h4>감사합니다.</h4>
				<p>고객님의 펫놀자 회원 가입이 <b>완료</b> 되었습니다.</p>
			</div>
			<br><br><hr><br>
			<div align="center" style="margin-top: 60px;">
				<button type="button" id="button" onclick="location.href='${ pageContext.servletContext.contextPath }/'"><b>메인으로</b></button>
			</div>
        </div>
	</div>
	
	<jsp:include page="../../common/memberFooter.jsp"/>
</body>
</html>