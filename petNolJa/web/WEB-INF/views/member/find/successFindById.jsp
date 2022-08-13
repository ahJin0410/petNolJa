<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫놀자</title>
<style>
    #memberId{
        color: coral;
    }
</style>
</head>
<body>
	<jsp:include page="../../common/memberHeader.jsp"/>

    <div align="center">
        <div class="innerwrap">
            <h2>아이디 확인</h2>
            <p id="script">
                입력하신 정보와 일치하는 아이디는 다음과 같습니다.
            </p><br><br><hr>
            <div class="middleTable" style="width:65; height: 100%; padding-top: 60px;">
                <h4><c:out value="${memberName}"/>님의 아이디는 <b id="memberId"><c:out value="${memberId}"/></b>입니다.</h4>
                <div align="center" style="margin-top: 60px;">
                    <button type="button" id="leftBtn" onclick="location.href='${ pageContext.servletContext.contextPath }/'"><b>비밀번호 찾기</b></button>&nbsp;&nbsp;&nbsp;
                    <button type="button" id="button" onclick="location.href='${ pageContext.servletContext.contextPath }/common/login'"><b>로그인</b></button>
                </div>
            </div><br><br><hr>
        </div>
    </div>
    <jsp:include page="../../common/memberFooter.jsp"/>
</body>
</html>