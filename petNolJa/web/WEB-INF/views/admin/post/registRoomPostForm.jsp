<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>객실 게시물</title>
<style>
	.file{
		background: #D0D0D0;
		width: 100%;
		height: 150px;
	}
	.picLine{
		clear: both;
		margin-top: 10px;
		border-top: 1.5px solid #D0D0D0;
	}
	.left{
		padding: 10px 45px;
		border: none;
		background: #D9D9D9;
		margin-right: 10px;
		font-family:'NanumSquare', serif;
		font-weight: 700;
		cursor: pointer;
	}
	.left:hover {
		background: #BFBFBF;
		color: white;
	}
	.right{
		padding: 10px 45px;
		border: none;
		background: #737373;
		color: white;
		margin-right: 10px;
		font-family:'NanumSquare', serif;
		font-weight: 700;
		cursor: pointer;
	}
	.right:hover {
		background: #404040;
	}
	
	.plus{
		float: left;
		border: none;
		cursor: pointer;
		color: #737373;
	}
	.plus:hover {
		color: #404040;
	}
</style>
</head>
<body>
    <jsp:include page="../../common/adminHeader.jsp"/>
	<div class=wrap align="center">
	    <div class="innerwrap" align="left">
            <form action="${pageContext.servletContext.contextPath}/regist/post/room" method="post" enctype="multipart/form-data">
                <div class="h4Div">
                    <h4 style="margin-bottom: 20px;">객실 게시물 등록</h4>
                </div>
                <div>
                    <table style="height: 420px;">
                        <tr>
                            <td class="title">제목</td>
                            <td class="answer"><input type="text" name="title" id="title" placeholder="객실명을 입력해주세요."></td>
                        </tr>
                        <tr>
                            <td class="title">등록자</td>
                            <td class="answer"><c:out value="${sessionScope.loginEmp.empName}"/>님</td>
                        </tr>
                        <tr>
                            <td class="title">사용 여부</td>
                            <td class="answer">
                                <input type="radio" name="useYn" id="Y"><label for="Y">사용</label>
                                <input type="radio" name="useYn" id="N"><label for="N">미사용</label>
                            </td>
                        </tr>
                        <tr style="height: 250px;">
                            <td colspan="2">
                                <textarea name="contents" id="contents" cols="50" rows="10" placeholder="객실 설명을 입력해주세요."></textarea>
                            </td>
                        </tr>
                    </table>
                    <div class="pic" style="margin-top: 20px;">
                        <h4 style="float: left; margin-right: 85%;">사진 업로드</h4>
                        <button type="button" class="plus"><h4>+</h4></button>
                        <div class="picLine"></div>
                        <div class="file" style="display: none;">
                            
                        </div>
                        <input type="file" name="selectImg" id="selectImg" multiple>
                    </div>
                </div>
                <div class="button" align="center">
                    <button class="left" type="reset">취소</button><button class="right" type="submit">등록</button>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="../../common/adminFooter.jsp"/>
<script>
    $(".plus").click(function(){
		$('.file').slideUp();
    	
    	if($(".plus").html() == "ㅡ"){
    		$(".plus").html('+');
	        $(".file").slideUp(200);
	        $(".picLine").css('border', '');
    	} else {
	        $(".plus").html('ㅡ');
	        $(".file").slideDown(200);
	        $(".picLine").css('border', 'none');
    	}
    });

</script>
</body>
</html>