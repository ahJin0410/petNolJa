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
	        <div align="center">
	            <h2 class="h2korea">약관동의</h2>
	            <p id="order"><b class="text-deco">① 약관동의</b> - ② 회원 정보 입력 - ③ 가입 완료</p>
	            <p id="script">
	                아래 동의서를 각각 확인한 후 개별적으로 동의하실 수 있습니다. 전체 동의시 체크되는 항목에는 선택 동의 항목이 포함되어 있습니다. <br>
		            펫놀자 회원 가입을 위하여 펫놀자(이하"회사")에서는 아래와 같이 개인정보를 수집, 이용 및 제공하고자 합니다.
	            </p>
	        </div>
	
	        <form action="${pageContext.servletContext.contextPath}/regist/agree" method="post" id="form">
	            <div class="check" align="left">
	               <br>
	               <input type="checkbox" name="allAgree" id="allAgree"><label for="allAgree" class="allAgree" > 전체 동의하기</label>
	               <br>
	               <br>
	               <hr>
	               <input type="checkbox" name="agree1" id="agree1" class="normal" required><label for="agree1" class="c1">펫놀자 회원약관 <b class="text-deco">(필수)</b></label>
	               <br>
	               <input type="checkbox" name="agree2" id="agree2" class="normal" required><label for="agree2"  class="c1">개인정보의 수집·이용에 관한 사항 <b class="text-deco">(필수)</b></label>
	               <br>
	               <input type="checkbox" name="agree3" id="agree3" class="normal"><label for="agree3"  class="c1">개인정보 수집이용에 관한 사항 <b>(선택)</b></label>
	               <br>
	               <div class="checksub1">
	               <input type="checkbox" name="allAgree1" id="allAgree1"><label for="allAgree1"  class="c1">상품안내 및 마케팅 활용을 위한 개인정보 수집·이용에 관한 동의 <b>(선택)</b></label><br>
	                  <input type="checkbox" name="sms1" id="sms1"><label for="sms1"> SMS</label>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="email1" id="email1"><label for="email1"> email</label>
	               </div>
	                  <br>
	               <div class="checksub2">
	                  <input type="checkbox" name="allAgree2" id="allAgree2"><label for="allAgree2"  class="c1">상품안내 및 마케팅 활용을 위한 개인정보 제3자 제공에 관한 동의 <b>(선택)</b></label><br>
	                  <input type="checkbox" name="sms1" id="sms1"><label for="sms1"> SMS</label>&nbsp;&nbsp;&nbsp;<input type="checkbox" name="email1" id="email1"><label for="email1"> email</label>
	               </div>
	               <div class="buttonDiv" align="center" style="margin-top: 60px;">
	                 <button type="reset" id="leftBtn" onclick="location.href='${ pageContext.request.contextPath }/index.jsp'"><b>이전</b></button>&nbsp;&nbsp;&nbsp; <button type="button" id="button"><b>다음</b></button>
	              </div>
	           </div>
	       </form>
	    </div>
    </div>
	<jsp:include page="../../common/memberFooter.jsp"/>
<script>
     $("#button").click(function(){
		if($("#agree1").is(":checked") && $("#agree2").is(":checked")){
			$("#form").submit();
		} else{
			alert('필수 사항을 체크해주세요!');
		}
	});
    
	$(".check").on("click", "#allAgree", function () {
		    $(this).parents(".check").find('input').prop("checked", $(this).is(":checked"));
	 });
	
	$(".check").on("click", "#allAgree1", function () {
	    $(this).parents(".checksub1").find('input').prop("checked", $(this).is(":checked"));
	 });
	
	$(".check").on("click", "#allAgree2", function () {
	    $(this).parents(".checksub2").find('input').prop("checked", $(this).is(":checked"));
	 });	
	
	$(".check").on("click", ".normal", function() {
	    var is_checked = true;
	
	    $(".check .normal").each(function(){
	        is_checked = is_checked && $(this).is(":checked");
	    });
	
	    $("#allAgree").prop("checked", is_checked);
	 });
</script>
</body>
</html>