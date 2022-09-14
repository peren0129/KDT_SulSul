<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
detailForm.jsp
<br>
<%-- <%=application.getRealPath("/resources")%> <br>
<%=application.getContextPath()%><br> 
<%=request.getContextPath()%><br> --%>

<script>
/* 	function comp(num,pageNumber){
		boolean flag = true;
		location.href="reply.qna?"+num+"&pageNumber="pageNumber;
	}
 */
</script>
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
			<!-- 관리자 아이디로 로그인시 ~~ 로 수정  -->
				<c:if test="${fn:contains(qna.writer, '길동')}">
					<table border="1" width="1200px" id="reply_area">
						<tr reply_type="all" style="display: none">
							<!-- 뒤에 댓글 붙이기 쉽게 선언 -->
							<td colspan="4"></td>
						</tr>
						<c:forEach var="replyList" items="${replyList}" varStatus="status">
							<tr
								reply_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>">
								<!-- 댓글의 depth 표시 -->
								<td width="820px"><c:if test="${replyList.depth == '1'}"> → </c:if>${replyList.reply_content}
								</td>
								<td width="100px">${replyList.reply_writer}</td>
								<td width="100px"><input type="password"
									id="reply_password_${replyList.reply_id}" style="width: 100px;"
									maxlength="10" placeholder="패스워드" /></td>
								<td align="center"><c:if test="${replyList.depth != '1'}">
										<button name="reply_reply" parent_id="${replyList.reply_id}"
											reply_id="${replyList.reply_id}">댓글</button>
										<!-- 첫 댓글에만 댓글이 추가 대댓글 불가 -->
									</c:if>
									<button name="reply_modify" parent_id="${replyList.parent_id}"
										r_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>"
										reply_id="${replyList.reply_id}">수정</button>
									<button name="reply_del"
										r_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>"
										reply_id="${replyList.reply_id}">삭제</button></td>
							</tr>
						</c:forEach>
					</table>
					<table border="1" width="1200px" bordercolor="#46AA46">
						<tr>
							<td width="500px">
							
							
							<!-- 
							이름: <input type="text" id="reply_writer"
								name="reply_writer" style="width: 170px;" maxlength="10"
								placeholder="작성자" /> 패스워드: <input type="password"
								id="reply_password" name="reply_password" style="width: 170px;"
								maxlength="10" placeholder="패스워드" />
							
							 -->
							
							
								<button id="reply_save" name="reply_save">댓글 등록</button>
							</td>
						</tr>
						<tr>
							<td><textarea id="reply_content" name="reply_content"
									rows="4" cols="50" placeholder="댓글을 입력하세요."></textarea></td>
						</tr>
					</table>

					<!--
						<input type="button" value="답변하기" onClick="location.href='reply.qna?num=${qna.num}&pageNumber=${pageNumber}'" >
						<input type="button" value="답변완료" onClick="comp()">  이거할라면 form필요
					-->
				</c:if>
		</tr>

		<tr>
			<td align="center" colspan="2"><input type="button" value="글수정"
				onClick="location.href='update.qna?num=${qna.num}&pageNumber=${pageNumber}'">
				<input type="button" value="글삭제"
				onClick="location.href='delete.qna?num=${qna.num}&pageNumber=${pageNumber }'">
				<%-- <input type="button" value="답글쓰기" onClick="location.href='reply.bd?ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'" > --%>
				<input type="button" value="글목록"
				onClick="document.location.href='list.qna?pageNumber=${pageNumber}'">
			</td>
		</tr>

		<tr>
		</tr>
	</table>
</center>
