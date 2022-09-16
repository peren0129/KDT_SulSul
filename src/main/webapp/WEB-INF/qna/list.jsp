<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!-- list.jsp -->
<br>

<center>
	<h2>QNA</h2>
	<small>글목록(전체 글: ${pageInfo.totalCount})</small>
	<hr style="width: 1000">
	<table border="0">
		<tr>
			<!-- <th>번호</th> -->
			<th width="100">문의날짜</th>
			<th width="200">카테고리</th>
			<th width="400">제목</th>
			<th width="70">작성자</th>
			<th width="70">조회수</th>
			<th width="100">문의상태</th>
		</tr>

		<c:if test="${ fn:length(lists) eq 0 }">
			<td colspan="5">작성된 게시글이 없습니다.</td>
		</c:if>
		<c:if test="${ fn:length(lists) > 0 }">
			<c:forEach var="list" items="${ lists }">
				<tr style="text-align: center;">
					<%-- <td align="right">${list.num }</td> --%>
					<!-- &nbsp -->
					<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
							pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
							value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
					<td>[${ list.cate }]</td>
					<td id="sub" style="text-align: left !important;">
						<%-- t
					<c:if test="${ list.re_level > 0 }">
							<fmt:parseNumber var="re_level" value="${ list.re_level }" />
							<img src="resources/images/level.gif" width="${ re_level*20 }"
								height="15">
							<img src="resources/images/re.gif">
					</c:if>
					 --%> <!-- 관리자 아이디로 로그인시 ~~ 로 수정  --> <c:if
							test="${fn:contains(list.cateopen, '비밀글')}">
							<img src="resources/images/00_secret.png" align="absmiddle">
						</c:if> <a
						href="detail.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>

						<!-- 파일 업로드 된 글 --> <c:if test="${list.image != null}">
							<img src="resources/images/00_attach_file.png" align="absmiddle">
						</c:if>
					</td>

					<td>${list.writer}</td>






					<td align="right">${ list.readcount }</td>




					<td align="center">${ list.reply }</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
	<br>
	<form action="list.qna" method="get">
		<select name="whatColumn">
			<option value="">전체검색</option>
			<option value="subject">글제목</option>
			<option value="writer">작성자</option>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색"> <input type="button" value="문의하기"
			onclick="window.location='write.qna'">
	</form>
	<!-- <br> <a href="write.qna">문의하기</a> -->
</center>

<center>${pageInfo.pagingHtml }</center>