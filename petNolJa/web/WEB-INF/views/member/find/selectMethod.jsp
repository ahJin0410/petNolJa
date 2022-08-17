<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>펫놀자</title>
<style>
    #poin{
        color: coral;
    }
    
	#memberEmail,#memberPhone{
		position:relative; 
		top:11.5px;
}	
</style>
</head>
<body>
    <jsp:include page="../../common/memberHeader.jsp"/>

    <div align="center">
        <div class="innerwrap">
            <h2>비밀번호 확인</h2>
            <p id="script">
                비밀번호가 기억나지 않으세요? 임시비밀번호 발급방법을 선택해주세요.
            </p><br><br><hr>
            <div class="middleTable" style="width:65; height: 100%; padding-top: 60px;">
                <h1 style="font-size: 50px; padding-bottom: 15px;"><i class="fa-solid fa-unlock-keyhole"></i></h1>
                <h4>원하시는 방법을 선택해 <b id="point">비밀번호를 확인</b>하실 수 있습니다.</h4>
                <div style="width: 78%; height: 100%; background-color: white; padding-left: 170px; padding-top: 20px; padding-bottom: 25px; margin-top: 30px;" align="left">
                    <p style="font-size: 16px;"><input type="radio" name="selectMethod" id="memberEmail" value="memberEmail"> <label for="memberEmail" class="c1">회원정보에 등록된 E-mail로 받기(${memberEmail})</label></p><br>
                    <p style="font-size: 16px;"><input type="radio" name="selectMethod" id="memberPhone" value="memberPhone"> <label for="memberPhone" class="c1">회원정보에 등록된 핸드폰번호로 받기(${memberPhone})</label></p>
                </div>
                <div align="center" style="margin-top: 40px;">
                    <button type="button" id="button">임시비밀번호 발송</button>
                </div>
            </div><br><br><hr>
        </div>
    </div>

    <jsp:include page="../../common/memberFooter.jsp"/>
<script>
    $("#button").click(function(){
    	var selectMethod = 'none';
        if($('input[type="radio"]:checked').val() == 'memberEmail'){
            console.log('memberEmail');
            selectMethod = 'memberEmail';
        } else if($('input[type="radio"]:checked').val() == 'memberPhone'){
            console.log('memberPhone');
            selectMethod = 'memberPhone';
        } else {
            alert('원하시는 방법을 선택해주세요.');
        }
        
        if(selectMethod == 'memberEmail' || selectMethod == 'memberPhone'){
            let member = '${memberId}';
        	$.ajax({
                url: '${pageContext.servletContext.contextPath}/member/modify/pwd',
                type: 'post',
                data: {
                    selectMethod:selectMethod,
                    memberId:member
                },
                success: function(data){
                    console.log(data);
                    location.href= '${pageContext.servletContext.contextPath}/member/modify/pwd?memberName=' + data.memberName + '&selectMethod=' + data.selectMethod + '&memberPhone=' + data.memberPhone + '&memberEmail=' + data.memberEmail;
                },
                error: function(error){
                    console.log(error);
                }
            });
        }
    });
</script>
</body>
</html>