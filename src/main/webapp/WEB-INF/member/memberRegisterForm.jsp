<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp" %>
 
memberRegisterForm.jsp<br>

<style>
	.error{
		color: red;
		font-size: 8;
		font-weight: bold;
	}
</style>

 <%-- 
<c:set var="path" value="${pageContext.request.contextPath}"/>

 --%>
 
<%-- 
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> 
 --%>
<c:set var="path" value="<%=request.getContextPath() %>"/>


<script type="text/javascript" src="${path}/resources/js/jquery.js"></script>


<script type="text/javascript">

	$(document).ready(function(){
		alert(11);
			
/* 		var isCheck = false;
		var isChange = false;
		var use;
		
		$('#id_check').click(function() {
			alert(3);
		
			isCheck = true;
			
			$.ajax({
				url : "idcheck.mem",
				data : ({
					inputid : $("input[name=id]").val()
				}),
				success : function(data){
					//alert('data:' + data);
					if ($('input[name="id"]').val() == "") {
						$('#idMessage').html("<font color=red>아이디를 입력해주세요.</font>");
						$('#idMessage').show();
					}

					else if(data=="YES"){
						$('#idMessage').html("<font color=blue
								>사용 가능한 아이디 입니다.</font>");
						$('#idMessage').show();
						use = "possible";
						isChange= false;
					}
					else{
						$('#idMessage').html("<font color=red>이미 등록된 아이디 입니다.</font>");
						$('#idMessage').show();
						use = "impossible";
					}
				}//success
			}); // ajax
		}); // click

		$('input[name=id]').keydown(function(){
			$('#idMessage').css('display','none');
			isChange = true;
			use = "";
		});
		
		$('#btnSubmit').click(function(){
			//alert(1);
			
			if(use == "impossible" ){
				alert('이미 사용중인 아이디 입니다.');
				return false;
			}
			else if(isCheck== false || isChange == true){
				alert("중복체크를 하세요");
				return false;
			}
		});//click
		 */
		/*function execPostCode() {
	         new daum.Postcode({
	             oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	 
	                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	 
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	 
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('zipcode1').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('zipcode2').value = fullRoadAddr;
	                document.getElementById('zipcode3').value = data.jibunAddress;
	               
	                console.log(data.zonecode);
	                console.log(fullRoadAddr);
	                
	                
	                $("[name=zipcode1]").val(data.zonecode);
	                $("[name=zipcode2]").val(fullRoadAddr);
	                $("[name=zipcode3]").val(data.jibunAddress);
	                
	            }
	         }).open();
	     }*/

	});//ready
</script>


<body>
<h1>회원가입</h1><br>
	<form:form method="post" action="registerForm.mem" commandName="member">

		<p>
			<label for="id">아이디 : </label>
			
			<input type="text" name="id" id="id" value="${member.id }">
			<input type="button" id="id_check" value="중복체크">
			<span id="idMessage"></span>
			<form:errors cssClass="error" path="id" />
		</p>
		
		<p>
			<label for="name">닉네임 : </label>
			
			<input type="text" name="name" id="name" value="${member.name }">
			<form:errors cssClass="error" path="name" />
		</p>
	
		<p>
			<label for="password">비밀번호 : </label>
			<input type="password" name="password" id="password" value="${member.password }">
			<form:errors cssClass="error" path="password"/>
		</p>
	<%-- 
		<p>
			<label>비밀번호 확인 : </label>
			<input type="password" name="password2" id="password2" value="${member.password }">
			<form:errors cssClass="error" path="password2"/>
		</p>
		 --%>
		<p>
			<label for="email">이메일 : </label>
			<input type="text" name="email" id="email" value="${member.email }">
			<form:errors cssClass="error" path="email"/>
		</p>
		<p>
			<label for="rrn1">성인인증 : </label>
			<input type="text" name="rrn1" id="rrn1" style="width: 130px;" value="${member.rrn1 }">-
			<form:errors cssClass="error" path="rrn1"/>
			
			<input type="text" name="rrn2" id="rrn2" style="width: 130px;" value="${member.rrn2 }">
		</p>
		<p>
			<label for="hp1">핸드폰 : </label>
			<input type="text" name="hp1" id="hp1" style="width: 80px;" value="${member.hp1 }">-
			<form:errors cssClass="error" path="hp1"/>
			
			<input type="text" name="hp2" id="hp2"  style="width: 90px;" value="${member.hp2 }">-
			
			<input type="text" name="hp3" id="hp3"  style="width: 90px;" value="${member.hp3 }">
		</p>
<%-- 		<p>
			<label for="zipcode1">배송지 : </label>
			<input type="text" name="zipcode1" id="zipcode1" style="width: 90px;" value="${member.zipcode1 }">
			<input type="button" id="zipcode_w" name ="zipcode_w" value="우편번호"><br>
			<form:errors cssClass="error" path="zipcode1"/>
			
			<input type="text" name="zipcode2" id="zipcode2" style="width: 230px;" value="${member.zipcode2 }"><br>
			
			<input type="text" name="zipcode3" id="zipcode3" style="width: 230px;" value="${member.zipcode3 }">
		</p>
	
 --%>
 
		<div class="form-group">                   
		<input class="form-control"style="width: 90px;" display: inline;" placeholder="우편번호" name="zipcode1" id="zipcode1" type="text" readonly="readonly" >
		    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
		</div><br>
		<div class="form-group">
		    <input class="form-control" style="width: 290px;" style="top: 5px;" placeholder="도로명 주소" name="zipcode2" id="zipcode2" type="text" readonly="readonly" />
		</div><br>
		<div class="form-group">
		    <input class="form-control" style="width: 290px;" placeholder="상세주소" name="zipcode3" id="zipcode3" type="text"  />
		</div>
		
		
		<p>
			<input type="submit" value="가입하기" id="btnSubmit">
		</p>
	</form:form>
