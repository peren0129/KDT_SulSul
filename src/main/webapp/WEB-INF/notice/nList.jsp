<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!-- list.jsp -->
<br>
<style>
th, td {
	border-bottom: 1px solid #DCDCDC;
	padding: 10px 0px;
}
</style>
<center>
	<h2>NOTICE</h2>
	<font color="#696969"> <small>글목록(전체 글:
			${pageInfo.totalCount})</small></font>
	<hr style="width: 1000px;">
	<table>
		<tr>
			<th width="50">번호</th>
			<th width="400">제목</th>
			<th width="150">날짜</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
		</tr>

		<c:if test="${ fn:length(lists) eq 0 }">
			<td colspan="5" align="center">작성된 게시글이 없습니다.</td>
		</c:if>
		<c:if test="${ fn:length(lists) > 0 }">
			<c:forEach var="list" items="${ lists }">
				<tr style="text-align: center;">
					<td align="right">${list.num }</td>
					<td style="text-align: left !important;">
						<!-- 관리자 아이디로 로그인시 ~~ 로 수정  --> <c:if
							test="${fn:contains(list.cate, '이벤트')}">
							<img src="resources/images/00_event.png" align="absmiddle">
						</c:if> <a
						href="detail.no?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>

						<!-- 파일 업로드 된 글 --> <c:if test="${list.image != null}">
							<img src="resources/images/00_attach_file.png" align="absmiddle">
						</c:if>
					</td>
					<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
							pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
							value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
					<td>${list.writer}</td>
					<td align="right">${ list.readcount }</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
	<br>
	<form action="nList.no" method="get">
		<select name="whatColumn">
			<option value="subject">글제목</option>
			<option value="writer">작성자</option>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form>
</center>

<center>${pageInfo.pagingHtml }</center>



