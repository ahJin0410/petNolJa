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
</head>
<body>
	<jsp:include page="../../common/memberHeader.jsp"/>
	
	<div align="center">
        <div class="innerwrap">
            <h2>회원 정보 입력</h2>
            <p id="order" style="padding-bottom: 40px;">① 약관동의 - <b class="text-deco">② 회원 정보 입력</b> - ③ 가입 완료</p>
            <form action="${pageContext.servletContext.contextPath}/member/regist/info" method="post" onsubmit="return registCheckInfo();" >
                <p align="left">1. 로그인 정보</p>
                <table class="topTable" style="width:100%; border-top: 0.1px solid black; height: 100px;">
                    <tr>
                        <td style="width: 20%;"><label for="memberId">아이디 <small class="ness"> (필수)</small></label></td>
                        <td><input type="text" name="memberId" id="memberId" placeholder="사용할 아이디를 입력해주세요." required="required">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkId">중복확인</button></td>
                    </tr>
                </table>
                <table class="topTable" style="width:100%; border-top: 0.1px solid rgba(224, 224, 224, 0.685); height: 210px;">
                    <tr>
                        <td style="width: 20%; height: 90px;"><label for="memberPwd">비밀번호 <small class="ness"> (필수)</small></label></td>
                        <td>
                            <input type="password" name="memberPwd" id="memberPwd" placeholder="사용할 비밀번호를 입력해주세요." required="required">
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 50px;"><label for="checkPwd">비밀번호 확인 <small class="ness"> (필수)</small></label></td>
                        <td>
                            <input type="password" name="checkPwd" id="checkPwd" placeholder="비밀번호를 다시 입력해주세요." required="required"><br>
                            <small>* 비밀번호는 8자 이상, 16자 이하의 영문자, 숫자, 특수문자를 조합하여 사용해야 합니다.</small>
                        </td>
                    </tr>
                     <tr><td></td></tr>
                </table>
                <p align="left">2. 고객 정보</p>
                <table class="middleTable" style="width:100%; border-top: 0.1px solid black; border-bottom: 0.1px solid gray; height: 350px;">
                    <tr>
                        <td style="width: 20%; height: 80px;"><label for="memberName">이름 <small class="ness"> (필수)</small></label></td>
                        <td><input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요."></td>
                    </tr>
                    <tr>
                        <td style="height: 50px;"><label for="memberBirth">생년월일 <small class="ness"> (필수)</small></label></td>
                        <td><input type="date" name="memberBirth" id="memberBirth" required="required"></td>
                    </tr>
                    <tr>
                        <td style="height: 80px;"><label for="memberPhone">핸드폰 <small class="ness"> (필수)</small></label></td>
                        <td>
                            <select name="memberPhoneFront" id="memberPhoneFront" style="width: 65px; border: none; padding-left: 5px;">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                            </select>
                            <input type="number" name="memberPhone" id="memberPhone" placeholder="-를 제외하고 입력해주세요." style="width: 200px;" required="required">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkPhone">인증번호</button>
                        </td>
                    </tr>
                    <tr id="checkTr">
                        <td></td>
                        <td style="height: 20px;"><input type="number" name="certificationNumber" id="certificationNumber" placeholder="인증번호를 입력해주세요." required="required">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkCertification" style="display: none;">확인</button></td>
                    </tr>
                    <tr>
                        <td style="height: 80px;"><label for="memberEmail">이메일 <small class="ness"> (필수)</small></label></td>
                        <td><input type="text" name="memberEmail" id="memberEmail" placeholder="사용할 이메일을 입력해주세요." required="required"></td>
                    </tr>
                    <tr><td></td></tr>
                </table>
                <div align="center" style="margin-top: 60px;">
                	<input type="text" name="termsNo" id="termsNo" style="display: none;">
                	<input type="text" name="agreeYn" id="agreeYn" style="display: none;">
                    <button type="reset" id="leftBtn" onclick="location.href='${ pageContext.servletContext.contextPath }/member/regist/agree'"><b>이전</b></button>&nbsp;&nbsp;&nbsp; <button type="submit" id="button"><b>다음</b></button>
                </div>
            </form>
        </div>
	</div>
	<input type="text" id="checkMemberId" style="display: none;">
	<jsp:include page="../../common/memberFooter.jsp"/>

<script>
	if('${message}' != ''){
		alert('${message}');
	}
	
	/* 유효성 검사 */
    $("#memberId").change(function(){
        $("#checkMemberId").val('1');
        $("#checkId").html('중복확인');
    });
    $("#memberPwd").change(function(){
        let memberPwd = $("#memberPwd").val();
        let regExpPwd = /^[a-zA-Z0-9\[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\](?=.*[a-z])(?=.*[0-9])(?=.*[\[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\])[a-zA-Z0-9\[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]{7,15}$/;
        if(!(regExpPwd.test(memberPwd))){
            alert('비밀번호는 8자 이상, 16자 이하의 영문자, 숫자 및 특수문자를 조합하여 사용해야 합니다.');
            $("#memberPwd").val('');
        }
    });
    $("#memberName").change(function(){
        let memberName = $("#memberName").val();
        let regExpName = /[0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
        $("#memberName").val(memberName.replace(regExpName, ''));
    });
    $("#memberEmail").change(function(){
    	let memberEmail = $("#memberEmail").val();
    	let regExpEmail = /^[a-zA-Z0-9+-_.]+@[a-zA-Z]+\.[a-zA-Z0-9-.]+$/;
    	if(!(regExpEmail.test(memberEmail))){
    		alert('올바른 이메일 형식으로 작성해주세요.');
    		$("#memberEmail").val('');
    	}
    });
	
	/* 아이디 중복확인 버튼 누를 경우 */
    $("#checkId").click(function(){
    	let checkId = $("#memberId").val();
        let regExpId = /^[a-zA-Z0-9](?=.*[a-zA-Z])[a-zA-Z0-9_.]{3,11}$/;
        if(checkId == '' || !(regExpId.test(checkId))){
        	alert('아이디는 영문자를 포함한 숫자, 특수문자( _. ) 4~12자리로 가능합니다.');
        	$("#memberId").val('');
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
	                	$("#checkId").html('확인완료');
	                }
	            },
	            error: function(error){
	                console.log(error);
	            }
	        });
        }
    });
	
    /* 핸드폰 문자 API 사용하여 인증번호SMS 발송 */
    $("#checkPhone").click(function(){
        let memberPhone = $("#memberPhone").val();
        if((memberPhone+"").length > 8){
        	alert('올바른 핸드폰 번호로 입력해 주세요.');
        	$("#memberPhone").val('');
        } else {
        	$("#certificationNumber").val('');
        	let front = $("#memberPhoneFront").val();
            let back = $("#memberPhone").val();
            let memberPhone = front + back;

            $.ajax({
                url: "${pageContext.servletContext.contextPath}/member/regist/checkPhone",
                type: "get",
                async: false,
                data: {memberPhone:memberPhone},
                success: function(data){
                	checkRandomNumber = data;
                	$("#checkCertification").css('display', '');
                },
                error: function(error){
                    console.log(error);
                }
            });
        }
    console.log(checkRandomNumber);
    });
    
    /* 인증번호 확인 후 핸드폰번호 수정되지 않도록 막기 */
    $("#checkCertification").click(function(){
        let userInput = $("#certificationNumber").val();
        if(userInput == checkRandomNumber){
            $("#memberPhoneFront").attr('readonly', true);
            $("#memberPhone").attr('readonly', true);
            $("#certificationNumber").attr('disabled', true);
            $("#checkPhone").html('인증완료');
            $("#checkPhone").attr('disabled', true);
            $("#checkTr").css('display', 'none');
        } else {
            alert('인증번호가 올바르지 않습니다. 다시 확인해주세요.');
        }
    });
    
    /* 다음(회원가입 진행) 버튼 누른경우 null값 체크 후 submit 진행 */
    function registCheckInfo(){
        if($("#memberId").val() == ''){
            alert('사용하실 아이디를 입력해주세요.');
            return false;
        }

        if($("#checkMemberId").val() == 1){
            alert('중복확인 버튼을 눌러 아이디 사용 가능여부를 확인해주세요.');
            return false;
        }

        if($("#memberPwd").val() == '' || $("#memberPwd").val() != $("#checkPwd").val()){
        	alert('비밀번호를 제대로 입력해주세요.');
        	$("#checkPwd").val('');
        	return false;
        }
        
        if($("#memberName").val() == ''){
        	alert('이름을 입력해주세요.');
        	return false;
        }
        
        if($("#checkPhone").html() != '인증완료'){
        	alert('핸드폰 인증을 진행해주세요.');
        	return false;
        }
        
        var memberId = $("#memberId").val();
		var data =  ${agreeList};
        var termsNo = new Array();
        var agreeYn = new Array();

        for(var i in data){
        	termsNo.push(data[i].termsNo);
        	agreeYn.push(data[i].agreeYn);
        }
        
        $("#termsNo").val(termsNo);
        $("#agreeYn").val(agreeYn);
        
        return true;
    }
	
</script>
</body>
</html>