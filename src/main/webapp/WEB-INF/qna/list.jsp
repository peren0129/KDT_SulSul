<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../mall/main_top.jsp"%>

<!-- list.jsp -->
<br>
<style>
th, td {
	border-bottom: 1px solid #DCDCDC;
	padding: 10px 0px;
}
</style>
<center>
	<h2>QNA</h2>
	<font color="#696969"> <small>글목록(전체 글:
			${pageInfo.totalCount})</small></font>
	<hr style="width: 1000px;">
	<table>
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
					<!-- &nbsp -->
					<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
							pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
							value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
					<td>[${ list.cate }]</td>
					<td id="sub" style="text-align: left !important;">
						<!-- 관리자 아이디로 로그인 또는 작성자 본인의 비공개 --> <c:choose>
							<c:when test="${fn:contains(list.cateopen, '비공개')}">
								<img src="resources/images/00_secret.png" align="absmiddle">
								<c:choose>
									<c:when test="${fn:contains(loginInfo.id, 'admin')}">
										<a
											href="detail.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
									</c:when>
									<c:when test="${loginInfo.id eq list.writer}">
										<a
											href="detail.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
									</c:when>
									<c:otherwise>
										<a onclick="alert('관리자 또는 작성자 본인만 조회 가능합니다.')">
											${list.subject}</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<a
									href="detail.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
							</c:otherwise>
						</c:choose> <!-- 파일 업로드 된 글 --> <c:if test="${list.image != null}">
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

<%@ include file="../mall/main_bottom.jsp"%>