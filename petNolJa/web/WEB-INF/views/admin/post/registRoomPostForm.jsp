<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<titl>객실 게시물</title>
</head>
<body>
    <div class="innerwrap">
        <div style="height: 30px; border-bottom: 1px solid #ccc;">
            <h3>객실 게시물 등록</h3>
        </div>
        <div>
            <table>
                <tr>
                    <td class="title">제목</td>
                    <td><input type="text" name="title" id="title" placeholder="객실명을 입력해주세요."></td>
                </tr>
                <tr>
                    <td class="title">등록자</td>
                    <td><c:out value="${sessionScope.loginEmp.empName}"/>님</td>
                </tr>
                <tr>
                    <td class="title">사용 여부</td>
                    <td>
                        <input type="radio" name="useYn" id="Y"><label for="Y">사용</label>
                        <input type="radio" name="useYn" id="N"><label for="N">미사용</label>
                    </td>
                </tr>
                <tr style="height: 300px;">
                    <td colspan="2">
                        <textarea name="contents" id="contents" cols="50" rows="10" placeholder="객실 설명을 입력해주세요."></textarea>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>