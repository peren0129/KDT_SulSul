<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
mallCateView.jsp
<br>


<center>

		<h2>주류 상품 전체보기</h2>
		<!-- 카테고리 -->
		<h3>
			<c:forEach var="category" items="${ catelists }">
				<a
					href="mallView.mall?whatColumn=category&keyword=${ category.cate }">
					${ category.cate }</a>&nbsp;&nbsp;&nbsp;
			</c:forEach>
		</h3>


	<!-- 상품 -->
	<table border="1" width="75%">
		<c:if test="${ fn:length(lists) eq 0 }">
			<tr>
				<td align="center">등록된 상품이 없습니다.</td>
			</tr>
		</c:if>

		<tr>
			<c:forEach var="alcohol" items="${ lists }" varStatus="i">
				<td><img
					src="<%=request.getContextPath()%>/resources/${alcohol.image}"
					width="250" height="250"><br> ${ alcohol.name }<br>
					${ alcohol.price }원</td>

				<c:if test="${ i.count % 4 == 0 }">
		</tr>
		<tr>
			</c:if>
			</c:forEach>
		</tr>
	</table>

	${ pageInfo.pagingHtml }

</center>


