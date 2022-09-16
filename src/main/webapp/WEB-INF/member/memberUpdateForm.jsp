<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp" %>
 
<style type="text/css">
	.err{
		color: red;
		font-size: 8;
		font-weight: bolder;
	}
</style>

	<form:form method="post" action="update.mem" commandName="member">

<h1>회원수정</h1><br>
		<p>
			<input type="hidden" name="num" value="${member.num }">
			<input type="hidden" name="pageNumber" value="${pageNumber }">
			
			<label for="id">아이디 : </label>
			<input type="text" name="id" id="id" value="${member.id }">
			<input type="button" id="id_check" value="중복체크">
			<span id="idMessage"></span>
			<form:errors cssClass="err" path="id" />
		</p>
	
		<p>
			<label for="name">닉네임 : </label>
			<input type="text" name="name" id="name" value="${member.name }">
			<form:errors cssClass="err" path="name"/>
		</p>
		<p>
			<label for="password">비밀번호 : </label>
			<input type="password" name="password" id="password" value="${member.password }">
			<form:errors cssClass="err" path="password"/>
		</p>
	<%-- 
		<p>
			<label>비밀번호 확인 : </label>
			<input type="password" name="password2" id="password2" value="${member.password }">
			<form:errors cssClass="err" path="password"/>
		</p>
		 --%>
		<p>
			<label for="email">이메일 : </label>
			<input type="text" name="email" id="email" value="${member.email }">
			<form:errors cssClass="err" path="email"/>
		</p>
		<p>
			<label for="rrn1">성인인증 : </label>
			<input type="text" name="rrn1" id="rrn1" style="width: 130px;" value="${member.rrn1 }">-
			<form:errors cssClass="err" path="rrn1"/>
			
			<input type="text" name="rrn2" id="rrn2" style="width: 130px;" value="${member.rrn2 }">
		</p>
		<p>
			<label for="hp1">핸드폰 : </label>
			<input type="text" name="hp1" id="hp1" style="width: 80px;" value="${member.hp1 }">-
			<form:errors cssClass="err" path="hp1"/>
			
			<input type="text" name="hp2" id="hp2"  style="width: 90px;" value="${member.hp2 }">-
			
			<input type="text" name="hp3" id="hp3"  style="width: 90px;" value="${member.hp3 }">
		</p>
		<p>
			<label for="zipcode1">배송지 : </label>
			<input type="text" name="zipcode1" id="zipcode1" value="${member.zipcode1 }"><br>
			<form:errors cssClass="err" path="zipcode1"/>
			
			<input type="text" name="zipcode2" id="zipcode2" value="${member.zipcode2 }">
			
			<input type="text" name="zipcode3" id="zipcode3" value="${member.zipcode3 }">
		</p>

		<p>
			<input type="submit" value="수정하기" id="btnSubmit">
		</p>
	</form:form>
