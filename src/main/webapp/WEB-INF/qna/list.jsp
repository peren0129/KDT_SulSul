<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
list.jsp
<br>

<center>
	<h2>QNA</h2><br>
<small>글목록(전체 글: ${pageInfo.totalCount})</small>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>문의날짜</th>
			<th>카테고리</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>문의상태</th>
		</tr>

		<c:if test="${ fn:length(lists) eq 0 }">
			<td colspan="5">작성된 데이터가 없습니다.</td>
		</c:if>
		<c:if test="${ fn:length(lists) > 0 }">
			<c:forEach var="list" items="${ lists }">
				<tr>
					<td align="right">${list.num }</td>
					<!-- &nbsp -->
					<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
							pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
							value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
					<td>${ list.cate3 }</td>
					<td><a
						href="getOneData.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${ list.subject }</a></td>
					<td>${ list.writer }</td>
					<td align="right">${ list.readcount }</td>
					<td align="center">${ list.reply }</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
	<br>
	<form action="list.qna" method="post">
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
<br>
<br>
<center>${pageInfo.pagingHtml }</center>