<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>펫놀자</title>
</head>
<body>
	<jsp:include page="../common/memberHeader.jsp"/>
	<div align="center" >
		<div class="innerwrap" style="width: 800px;">
		    <h2>Login</h2>
		    <form action="${pageContext.servletContext.contextPath}/common/login" method="post">
		        <div align="center">
		            <table style="width: 90%;">
		                <tr>
		                    <td colspan="3" height="25px"><hr></td>
		                </tr>
		                <tr>
		                    <td><input type="text" name="id" id="id" max="15" placeholder="아이디를 입력하세요." style="width: 450px;"></td>
		                    <td rowspan="2" align="right"><button id="button" type="submit" style="height: 65px; width: 220px;"> 로그인</button></td>
		                </tr>
		                <tr>
		                    <td><input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요." style="width: 450px;"></td>
		                </tr>
		            </table>
		        </div>
		    </form><br>
		    <div class="registwrap" align="center">
		        <table style="width: 90%; text-align: center;">
		            <tr>
		                <td width="30%"><a href="${pageContext.servletContext.contextPath}/member/regist/agree">회원가입</a></td>
		                <td>|</td>
		                <td width="30%"><a href="${pageContext.servletContext.contextPath}/member/find/id">아이디 찾기</a></td>
		                <td>|</td>
		                <td width="30%"><a href="${pageContext.servletContext.contextPath}/member/find/pwd">비밀번호 찾기</a></td>
		            </tr>
		        </table>
		    </div>
		</div>
	</div>
	<jsp:include page="../common/memberFooter.jsp"/>
<script>
	if('${message}' != ''){
		alert('${message}');
	}
</script>
</body>
</html>