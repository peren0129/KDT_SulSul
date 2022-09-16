<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<style type="text/css">
table {
	text-align: center;
	align: center;
	margin: auto;
}
 
#title {
	font-size: 40pt;
	color: #F4BFBF;
	margin-top:10%;
	margin-bottom:10%
	
}
</style>


<form action="login.mem" method="post">
	<table border="0" align="center" height="40" width="430"
		style="border: solid 4px margin:4%">

		<tr height="20px">
			<td><div id="title">LOGIN</div></td>
		</tr>

		<tr width="400px" height="20px">
			<td><input type="text" name="id"
				style="height: 40px; width: 430px;"></td>
		</tr>
	</table>

	<table border="0" align="center" height="40" width="430"
		style="border: solid 4px margin-top:1%">

		<tr width="400px" height="20px">
			<td><input type="password" name="password"
				style="height: 40px; width: 430px;"></td>
		</tr>
	</table>

	<table align="center" height="40" style="margin-top: 1%">
		<tr width="400px" height="20px">
			<td><input type="submit" value="로그인"
				style="height: 50px; width: 430px; background-color: #F4BFBF; color: black; font-size: 16px;"
				location.href='<%=request.getContextPath()%>/login.mem'">
		</tr>
	</table>

	<table align="center" height="0" width="440" border="0"
		style="border: solid 1px #F4BFBF; margin-top: 2%">
	</table>

	<table>
		<tr width="400px" height="10px">
			<td align="center"></td>
		</tr>
		
	</table>
	
	<table align="center" height="50" style="margin-top:1%">
		<tr width="400px" height="20px">
			<td>
			<a style="text-decoration:none;" href="registerForm.mem">회원가입 |</a>
		
			<td><a style="text-decoration:none;" href="findId.mem">아이디찾기 |</a></td>
			
			<td><a style="text-decoration:none;" href="./memberFindPw.jsp">비밀번호찾기</a></td>
		</tr>

	</table>
</form>

