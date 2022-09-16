<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- main_top.jsp -->
<style>
table {
	margin: 0px auto;
}
</style>

<table width="80%">
	<%
		String id = (String)session.getAttribute("id");
		if(id==null){
			%>
	<tr>
		<td align="left">
			<a href="<%=request.getContextPath() %>/main.jsp"> 
				<img src="<%=request.getContextPath() %>/resources/logo/술마트_로고 (2).JPG" width="200" height="80">
			</a>
		</td>
		<td align="right" valign="bottom"><a href="registerForm.mem">회원가입</a>&nbsp;| <a
			href="login.mem">로그인</a></td>
	</tr>
	<%
		}else{
			%>
	<tr>
		<td align="left"><a
			href="<%=request.getContextPath() %>/main.jsp"><img src=""
				width="80" height="40"></a></td>
		<td align="right" valign="bottom"><%= id %> 님 <a href="">로그아웃</a>
		</td>
	</tr>
	<%
			if(id.equals("admin")){
				%>
	<tr>

	</tr>
	<%
			}//if
		}//else
		%>
	
	<tr>
		<td align="center" colspan="2">
			<form action="mallSearchView.mall">
				<select name="whatColumn">
					<option value="">선택
					<option value="name">상품명
					<option value="brand">브랜드
				</select>
				<input type="text" name="keyword">
				<input type="submit" value="검색">
			</form>
		</td>
	</tr>

	<tr>
		<td align="center" colspan="2" valign="bottom" height="30"><a
			href="mallView.mall">주류 상품</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
			<!-- <a href="">베스트</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  -->
			<a href="">마이페이지</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
			<a href="">장바구니</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
			<a href="">게시판</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
			<a href="">상품후기</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
			<a href="list.qna">QNA</a>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		