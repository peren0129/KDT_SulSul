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
	<h2>NOTICE</h2>
	<font color="#696969"> <small>글목록(전체 글:
			${pageInfo.totalCount})</small></font>
	<hr style="width: 1000px;">
	<table>
		<tr>
			<th width="50" align="left">번호</th>
			<th width="400">제목</th>
			<th width="150">날짜</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
		</tr>

		<c:if test="${ fn:length(lists) eq 0 }">
			<td colspan="5" align="center">작성된 게시글이 없습니다.</td>
		</c:if>
		<c:if test="${fn:length(lists) > 0 }">
			<c:forEach var="list" items="${ lists }">

				<c:choose>
					<c:when test="${fn:contains(loginInfo.id, 'admin')}">
						<tr style="text-align: center;">
							<td align="left">${list.num }</td>
							<td style="text-align: left !important;">
								<c:if test="${list.cate eq '이벤트'}">
									<img src="resources/images/00_event.png" align="absmiddle"
										height="20px" width="30px">
								</c:if> 
								<!-- 비공개 --><c:if test="${list.cateopen eq '비공개'}">
									<img src="resources/images/00_secret.png" align="absmiddle">
								</c:if> 
									<a href="detail.no?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
								<!-- 파일 업로드 --> <c:if test="${list.image != null}">
									<img src="resources/images/00_attach_file.png"
										align="absmiddle">
								</c:if></td>
							<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
									pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
									value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
							<td>${list.writer}</td>
							<td align="right">${ list.readcount }</td>
						</tr>
					</c:when>
					<c:when test="${not fn:contains(loginInfo.id, 'admin')}">
						<c:if test="${list.cateopen eq '전체공개'}">
							<tr style="text-align: center;">
								<td align="left">${list.num }</td>
								<td style="text-align: left !important;"><c:if
										test="${fn:contains(list.cate, '이벤트')}">
										<img src="resources/images/00_event.png" align="absmiddle"
											height="20px" width="30px">
									</c:if> <a
									href="detail.no?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
									<!-- 파일 업로드 --> <c:if test="${list.image != null}">
										<img src="resources/images/00_attach_file.png"
											align="absmiddle">
									</c:if></td>
								<td><fmt:parseDate var="reg_date"
										value="${ list.reg_date }" pattern="yyyy-MM-dd" /> <fmt:formatDate
										var="formatDate" value="${ reg_date }" pattern="yyyy-MM-dd" />
									${formatDate}</td>
								<td>${list.writer}</td>
								<td align="right">${ list.readcount }</td>
							</tr>
						</c:if>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:if>

	</table>
	<br>
	<!-- 	<form action="list.no" method="get">
		<select name="whatColumn">
			<option value="cate">공지</option>
			<option value="cate">이벤트</option>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form> -->
	<c:if test="${loginInfo.id eq 'admin'}">
		<input type="button" value="공지글 작성"
			onclick="window.location='write.no'">
	</c:if>
</center>

<center>${pageInfo.pagingHtml }</center>
<%@ include file="../mall/main_bottom.jsp"%>


