<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>  
detailForm.jsp
<br>
<%-- <%=application.getRealPath("/resources")%> <br>
<%=application.getContextPath()%><br> 
<%=request.getContextPath()%><br> --%>

<center>
	<h2>게시글 상세보기</h2>
		<hr style="width: 1200">
	<table border="0" width="500" height="70" align="center">
		<tr>
			<td>카테고리</td>
			<td>&nbsp;${qna.cate}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>&nbsp;${qna.writer}</td>
			
	<%-- 	<td>공개여부</td>
			<td>&nbsp;${qna.cateopen}</td> --%>
		</tr>
		<tr>
			<td>제목</td>
			<td>&nbsp;${qna.subject}</td>
		</tr>
		<tr>
			<td>본문</td>
			<td>&nbsp;${qna.content}</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><img height=70 width=70 
				src="<%=request.getContextPath()%>/resources/${qna.image}"></td>
		</tr>
		<tr>
			<td align="center">
		<input type="button" value="글수정" onClick="location.href='update.bd?num=${article.num }&pageNumber=${pageNumber }'">
		<input type="button" value="글삭제" onClick="location.href='delete.bd?num=${article.num }&pageNumber=${pageNumber }'">
		<%-- <input type="button" value="답글쓰기" onClick="location.href='reply.bd?ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'" > --%>
		
		
		
		
	<!-- 관리자 아이디로 로그인시 ~~ 로 수정  -->
		<c:if test="${fn:contains(qna.writer, '길동')}">
		<input type="button" value="답변하기" onClick="location.href='reply.bd?num=${article.num }&pageNumber=${pageNumber }'" >
		</c:if>

		
		
		
		<input type="button" value="글목록" onClick="document.location.href='list.bd?pageNumber=${pageNumber }'" >
			</td>
		</tr>

		<tr>
		</tr>
	</table>
</center>
