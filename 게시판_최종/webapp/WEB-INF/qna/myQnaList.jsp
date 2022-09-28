<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../mall/main_top.jsp"%>
<%@ include file="../mall/myPage_top.jsp"%>
<div class="col-9">
	<hr>
	<h2>1:1 문의</h2>
	<hr>

	<table border="1" align="center" class="table table-hover">
		<tr class="table-light">
			<td colspan="5"><b>${loginInfo.name }(${loginInfo.id })</b> 님의
				문의내역</td>
		</tr>
		<%-- 		<tr class="table-light">
			<td colspan="5"><b> 문의 내역이 <font color="blue">${pageInfo.totalCount}</font>건
					있습니다.
			</b></td>
		</tr> --%>
		<tr align="center" class="table-info">
			<th>문의날짜</th>
			<th>카테고리</th>
			<th>제목</th>
			<th width="7%">조회수</th>
			<th>문의상태</th>
		</tr>

		<c:if test="${ fn:length(lists) eq 0 }">
			<td colspan="5">1:1 문의 내역이 없습니다.</td>
		</c:if>
		<c:if test="${ fn:length(lists) > 0 }">
			<c:forEach var="list" items="${ lists }">
				<c:if test="${loginInfo.id eq list.writer}">
					<tr align="center" class="table-light">
						<!-- &nbsp -->
						<td><fmt:parseDate var="reg_date" value="${ list.reg_date }"
								pattern="yyyy-MM-dd" /> <fmt:formatDate var="formatDate"
								value="${ reg_date }" pattern="yyyy-MM-dd" /> ${formatDate}</td>
						<td>[${ list.cate }]</td>
						<td id="sub" style="text-align: left !important;">
							<!-- 관리자 아이디로 로그인 또는 작성자 본인의 비공개 --> <c:if
								test="${fn:contains(list.cateopen, '비공개')}">
								<img src="resources/images/00_secret.png" align="absmiddle">
							</c:if> <a
							href="myDetail.qna?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.subject}</a>
							<!-- 파일 업로드 된 글 --> <c:if test="${list.image != null}">
								<img src="resources/images/00_attach_file.png" align="absmiddle">
							</c:if>
						</td>
						<td>${list.readcount}</td>
						<td>${list.reply}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
	</table>
	<div align="right">
		<input type="button" value="문의하기" class="btn btn-primary btn-sm"
			onclick="window.location='myWrite.qna'">
	</div>
	<br>
	<div align="center">
		<div class="btn-group" role="group"
			aria-label="Basic mixed styles example">
			<button type="button" class="btn btn-warning">${pageInfo.pagingHtml }</button>
		</div>
	</div>
</div>

<div class="col-2"></div>
<br>
<%@ include file="../mall/main_bottom.jsp"%>