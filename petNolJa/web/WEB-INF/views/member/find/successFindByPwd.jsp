<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>펫놀자</title>
<style>
    #point{
        color: coral;
    }
</style>
</head>
<body>
	<jsp:include page="../../common/memberHeader.jsp"/>

    <div align="center">
        <div class="innerwrap">
            <h2>비밀번호 확인</h2>
            <p id="script">
                회원님의 개인정보 보호를 위해 관련 정보의 일부가 *로 표시됩니다.
            </p><br><br><hr>
            <div class="middleTable" style="width:65; height: 100%; padding-top: 60px;">
            	<h1 style="font-size: 50px; padding-bottom: 15px;"><i class="fa-solid fa-paper-plane"></i></h1>
                <h4><c:out value="${memberName}"/>님의 임시비밀번호가 <b id="point"></b>으로 발송완료 되었습니다.</h4>
                <div align="center" style="margin-top: 60px;">
                    <button type="button" id="button" onclick="location.href='${ pageContext.servletContext.contextPath }/common/login'"><b>로그인</b></button>
                </div>
            </div><br><br><hr>
        </div>
    </div>

    <jsp:include page="../../common/memberFooter.jsp"/>

<script>
    if('${selectMethod}' == 'memberPhone'){
        $("#point").html('${memberPhone}');
    }
    
    if('${selectMethod}' == 'memberEmail'){
    	$("#point").html('${memberEmail}');
    }
</script>
</body>
</html>