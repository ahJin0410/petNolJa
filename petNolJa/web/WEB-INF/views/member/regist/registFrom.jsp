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
	<jsp:include page="../../common/memberHeader.jsp"/>
	
	<div align="center">
        <div class="innerwrap">
            <h2>회원 정보 입력</h2>
            <p id="order" style="padding-bottom: 40px;">① 약관동의 - <b class="text-deco">② 회원 정보 입력</b> - ③ 가입 완료</p>
            <form action="#" method="post">
                <table class="topTable" style="width: 80%; border-top: 0.1px solid gray; height: 150px;">
                    <tr>
                        <td style="width: 20%;"><label for="memberId">아이디</label></td>
                        <td><input type="text" name="memberId" id="memberId" placeholder="사용할 아이디를 입력해주세요.">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkId">중복확인</button></td>
                    </tr>
                    <tr>
                        <td><label for="memberPwd">비밀번호</label></td>
                        <td><input type="password" name="memberPwd" id="memberPwd" placeholder="사용할 비밀번호를 입력해주세요."></td>
                    </tr>
                    <tr>
                        <td><label for="checkPwd"></label></td>
                        <td><input type="password" name="checkPwd" id="checkPwd" placeholder="비밀번호를 다시 입력해주세요."></td>
                    </tr>
                </table>
                <table class="middleTable" style="width: 80%; border-top: 0.1px solid gray; border-bottom: 0.1px solid gray; height: 250px;">
                    <tr>
                        <td style="width: 20%;"><label for="memberName">이름</label></td>
                        <td><input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요."></td>
                    </tr>
                    <tr>
                        <td><label for="memberBirth">생년월일</label></td>
                        <td><input type="date" name="memberBirth" id="memberBirth"></td>
                    </tr>
                    <tr>
                        <td><label for="memberPhone">핸드폰</label></td>
                        <td>
                            <select name="memberPhoneFront" id="memberPhoneFront" style="width: 65px; border: none; padding-left: 5px;">
                                <option value="010">010</option>
                                <option value="010">011</option>
                                <option value="010">016</option>
                                <option value="010">017</option>
                            </select>
                            <input type="number" name="memberPhone" id="memberPhone" placeholder="-를 제외하고 입력해주세요." style="width: 200px;">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkPhone">인증번호</button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="number" name="certificationNumber" id="certificationNumber" placeholder="인증번호를 입력해주세요.">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkCertification">확인</button></td>
                    </tr>
                    <tr>
                        <td><label for="memberEmail">이메일</label></td>
                        <td><input type="text" name="memberEmail" id="memberEmail" placeholder="사용할 이메일을 입력해주세요."></td>
                    </tr>
                </table>
                <div align="center" style="margin-top: 60px;">
                    <button type="reset" id="leftBtn" onclick="location.href='${ pageContext.servletContext.contextPath }/regist/agree'"><b>이전</b></button>&nbsp;&nbsp;&nbsp; <button type="submit" id="button"><b>다음</b></button>
                </div>
            </form>
        </div>
	</div>
	<div>
		<input type="text" id="checkMemberId">
	</div>
	<jsp:include page="../../common/memberFooter.jsp"/>

<script>
	
	/* 아이디 중복확인 버튼 누를 경우 */
    $("#checkId").click(function(){
    	let checkId = $("#memberId").val();
        let regExpId = /[-a-zA-Z0-9_.](?=.*[a-z]).{3,12}$/;
        if(checkId == '' || !(regExpId.test(checkId))){
        	alert('아이디는 4~12자리의 영문자와 숫자만 입력해주세요.(영문자 필수/숫자 선택)');
        } else {
	        $.ajax({
	            url: "${pageContext.servletContext.contextPath}/member/regist/checkId",
	            type: "get",
	            data: {checkId:checkId},
	            success: function(data){
	                if(data == 1){
	                    alert('이미 사용중인 아이디입니다. 다시 입력해주세요.');
	                   	$("#memberId").val('');
	                   	$("#checkMemberId").val(data);
	                } else{
	                	alert('사용 가능한 아이디입니다. 다음 단계로 이동해주세요.');
	                	$("#checkMemberId").val(data);
	                }
	            },
	            error: function(error){
	                console.log(error);
	            }
	        });
        }
    });
	
    /* 중복확인 완료 했는지 여부 확인하기 위한 이벤트 처리 */
    $("#memberId").change(function(){
        $("#checkMemberId").val('1');
    });
/*     $("#memberPhone").change(function(){
        $("#memberPhone").val();
    }); */
    
    $("#checkPhone").click(function(){
        let memberPhone = $("#memberPhone").val();
        if((memberPhone+"").length > 8){
        	alert('올바른 핸드폰 번호로 입력해 주세요.');
        } else {
        	
        }
    });

</script>
</body>
</html>