<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>  
detailForm.jsp
<br>
<%-- <%=application.getRealPath("/resources")%> <br>
<%=application.getContextPath()%><br> 
<%=request.getContextPath()%><br> --%>


<center>
	<h2>${qna.subject}</h2>
		<hr style="width: 1000">
	<table border="0" width="600" height="70" align="center">
		<tr>
			<td width="100">카테고리</td>
			<td>${qna.cate}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${qna.writer}</td>
			
	<%-- 	<td>공개여부</td>
			<td>&nbsp;${qna.cateopen}</td> --%>
		</tr>
<%-- 		<tr>
			<td>제목</td>
			<td>&nbsp;${qna.subject}</td>
		</tr> --%>
		<tr height="300" valign="top">
			<td>본문</td>
			<td>${qna.content}</td>
		</tr>
		<tr>
			<td valign="top">첨부파일</td>
			<td><img height=70 width=70 
				src="<%=request.getContextPath()%>/resources/${qna.image}"></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
		<input type="button" value="글수정" onClick="location.href='update.qna?num=${qna.num}&pageNumber=${pageNumber}'">
		<input type="button" value="글삭제" onClick="location.href='delete.qna?num=${qna.num}&pageNumber=${pageNumber }'">
		<%-- <input type="button" value="답글쓰기" onClick="location.href='reply.bd?ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'" > --%>
		
		
		
		
	<!-- 관리자 아이디로 로그인시 ~~ 로 수정  -->
		<c:if test="${fn:contains(qna.writer, '길동')}">
		<input type="button" value="답변하기" onClick="location.href='reply.qna?num=${qna.num}&pageNumber=${pageNumber}'" >
		</c:if>

		
		<input type="button" value="글목록" onClick="document.location.href='list.qna?pageNumber=${pageNumber}'" >
			</td>
		</tr>

		<tr>
		</tr>
	</table>
</center>
