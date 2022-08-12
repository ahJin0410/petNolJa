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
</style>
</head>
<body>
    <jsp:include page="../../common/memberHeader.jsp"/>

    <div align="center">
        <div class="innerwrap">
            <h2>아이디 찾기</h2>
            <p id="script">
                아이디가 기억나지 않으세요? 회원님의 정보로 아이디를 확인하실 수 있습니다.
            </p><br><br><hr>
            <form action="${pageContext.servletContext.contextPath}/member/find/id" method="post" onsubmit="return checkInfo();">
                <table class="middleTable" style="width:65; height: 100%; padding-top: 50px;">
                    <tr>
                        <td style="width: 20%; height: 80px;"><label for="memberName">이름</label></td>
                        <td><input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요." required="required"></td>
                    </tr>
                    <tr>
                        <td style="height: 50px;"><label for="memberBirth">생년월일</label></td>
                        <td><input type="number" name="memberBirth" id="memberBirth" placeholder="법정생년월일 6자리를 입력해주세요." required="required"></td>
                    </tr>
                    <tr>
                        <td style="height: 80px;"><label for="memberPhone">핸드폰</label></td>
                        <td>
                            <input type="number" name="memberPhone" id="memberPhone" placeholder="핸드폰 번호를 입력해주세요. (- 제외)" required="required">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkPhone">인증번호</button>
                        </td>
                    </tr>
                    <tr id="checkNumber" style="display: none;">
                        <td style="width: 20%;"></td>
                        <td style="height: 40px;"><input type="number" name="certificationNumber" id="certificationNumber" placeholder="인증번호를 입력해주세요.">&nbsp;&nbsp;&nbsp;<button type="button" class="checkBtn" id="checkCertification">확인</button></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2" style="height: 80px;">
                        	<button type="button" id="leftBtn" onclick="location.href='${ pageContext.servletContext.contextPath }/member/regist/agree'" style="display: none;"><b>회원가입</b></button>&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="button"><b>아이디 찾기</b></button>
                        </td>
                    </tr>
                </table>
                <div align="center" style="margin-top: 60px;">
                    
                </div>
            </form>
            <hr>
        </div>
    </div>
    <jsp:include page="../../common/memberFooter.jsp"/>
<script>
    if('${message}' != ''){
    	alert('${message}');
    	$("#leftBtn").css("display", "");
    }

    $("#memberBirth").change(function(){
        let memberBirth = $("#memberBirth").val() + '';
        if(memberBirth.length > 6 || memberBirth.length < 5){
            alert('생년월일 6자리를 입력해주세요.\n(YYYYMMDD)');
            $("#memberBirth").val('');
        };
    });
    
    $("#memberPhone").change(function(){
        let memberPhone = $("#memberPhone").val() + '';
        
        if(memberPhone.length > 11 || memberPhone.length < 10){
            alert('회원가입 시 등록한 핸드폰 번호를 입력해주세요.\n(01012341234)');
            $("#memberPhone").val('');
        }
    });

    $("#checkPhone").click(function(){
        let memberPhone = $("#memberPhone").val();
        if(memberPhone == '' || memberPhone == null){
            alert('회원가입 시 등록한 핸드폰 번호를 입력해주세요.');
        }
        $("#checkPhone").html('재인증');

        $.ajax({
            url: "${pageContext.servletContext.contextPath}/member/regist/checkPhone",
            type: "get",
            data: {memberPhone:memberPhone},
            success: function(data){
                console.log(data);
                checkRandomNumber = data;
                $("#checkNumber").css('display', '');
            },
            error: function(error){
                console.log(error);
            }
        });
    });
    
    $("#checkCertification").click(function(){
        let userInput = $("#certificationNumber").val();
        if(userInput == checkRandomNumber){
            $("#memberPhone").attr('readonly', true);
            $("#certificationNumber").attr('disabled', true);
            $("#checkPhone").html('인증완료');
            $("#checkPhone").attr('disabled', true);
            $("#checkNumber").css('display', 'none');
        } else {
            alert('인증번호가 올바르지 않습니다. 다시 확인해주세요.');
        }
    });
    
    function checkInfo(){
        if($("#memberName").val() == ''){
            alert('이름을 입력해주세요.');
            return false;
        }
        
        if($("#memberBirth").val() == ''){
            alert('생년월일을 입력해주세요.\n(YYYYMMDD)');
            return false;
        }
        
        if($("#memberPhone").val() == ''){
            alert('핸드폰번호를 입력해주세요.');
            return false;
        }
        
        if($("#certificationNumber").val() == ''){
        	alert('핸드폰 인증을 진행해주세요.');
        	return false;
        } else if($("#checkPhone").html() != '인증완료'){
        	alert('핸드폰 인증을 완료해주세요.');
        	return false;
        }
        
        return true;
    }
</script>
</body>
</html>