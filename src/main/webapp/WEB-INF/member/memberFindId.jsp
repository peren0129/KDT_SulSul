<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">

#title {
	font-size: 15pt;
	margin-top: 5%;
	margin-bottom: 5%
}
</style>

<script type="text/javascript">

window.onload = function() {
	document.getElementById('submit').onclick = function() {
		
		if ( document.Idfind.id.value.trim() == '' ) {
			alert( 'ID를 입력해주세요' );
			return false;
		}
		if ( document.Idfind.email.value.trim() == '' ) {
			alert( '이메일을 입력해주세요' );
			return false;
		}
		document.Idfind.submit();
	}
}


</script>

<form action="findId.mem" method="post" name="Idfind">

      	<div class="row">
        	<div align="center">
				<h2>아이디 찾기</h2>
			</div>	
	
	<table width="380px" height="70px" align="center" border="0" class="mo"
		style="font-size: 14px;">
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" id="name" placeholder="이름을 입력하세요.">
			</td>
		</tr>
		<tr>
			<td>가입메일주소</td>
			<td>
				<input type="text" name="email" id="email" placeholder="이메일을 입력하세요.">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="아이디 검색">
			</td>
		</tr>
	</table>
</form>

