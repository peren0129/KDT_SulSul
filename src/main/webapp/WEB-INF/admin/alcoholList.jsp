<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
alcoholList.jsp
<br>

<style>
	table {
		float: left;
		
	}
	
	table {
		margin-left: 60;
	}
	table:first-child {
		margin-top: 20;
	}
	caption{
		
	}
	.err {
		font-size: 9px;
		font-weight: bold;
		color: red;
	}
</style>


<center>

	<h2>주류 상품 관리</h2>

	<!-- 상품 등록 -->
	<form:form commandName="alcohol" action="insertAlcohol.ad" method="post"
		enctype="multipart/form-data">
		<table border="1">
		<caption>주류 상품 등록</caption>
			<tr>
				<td>카테고리</td>
				<td><select name="category">
						<option value="">선택
							<c:forEach var="list" items="${ lists2 }">
								<option value="${ list.cate }">${ list.cate }
							</c:forEach>
				</select>
				<form:errors cssClass="err" path="category"></form:errors>
				</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input name="name" value="애플리즈 헤베 9도 330ml">
				<form:errors cssClass="err" path="name"></form:errors>
				</td>
			</tr>
			<tr>
				<td>브랜드</td>
				<td><input name="brand" value="한국애플리즈"></td>
			</tr>
			<tr>
				<td>원산지</td>
				<td><input name="country" value="미국"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input name="price" value="5700">원</td>
			</tr>
			<tr>
				<td>적립포인트</td>
				<td><input name="point" value="57">point</td>
			</tr>
			<tr>
				<td>재고수량</td>
				<td><input name="stock" value="200">개</td>
			</tr>
			<tr>
				<td>스펙</td>
				<td><select name="spec">
						<option value="">선택
						<option value="BEST">BEST
						<option value="STEADY">STEADY
				</select></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><textarea name="content" rows="10" cols="50">애플리즈 헤베 9도 330ml</textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="upload"></td>
			</tr>
			<tr>
				<td>내용이미지</td>
				<td><input type="file" name="upload2"></td>
			</tr>
			<tr>
				<td>입고일자</td>
				<td><input type="text" name="input_date" value="2022-09-22"></td>
			</tr>
			<tr>
				<td>유통기한</td>
				<td><input type="text" name="exp_date" value="2024-03-10"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록"></td>
			</tr>
		</table>
		<br>
	</form:form>


	<!-- 상품 리스트 -->
	<table border="1" style="width: 55%;">
	<caption>주류 상품 리스트 (총 ${ totalCount } 개)</caption>
	
	<c:if test="${ fn:length(lists) eq 0}">
		<tr>
			<td colspan="6" align="center">등록된 상품이 없습니다.</td>
		</tr>
	</c:if>
	
		<c:forEach var="alcohol" items="${ lists }" varStatus="i">
			<tr>
				<td rowspan="4"><img
					src="<%= request.getContextPath() %>/resources/${ alcohol.image }"
					width="100" height="100"></td>
				<td>
				코드 ${ alcohol.code }</td>
				<td colspan="3">${ alcohol.name }</td>
				<td colspan="2">재고 : ${ alcohol.stock }
				</td>
				<td rowspan="5"><a href="updateAlcohol.ad?num=${ alcohol.num }">수정</a>
				<a href="deleteAlcohol.ad?num=${ alcohol.num }">삭제</a></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>브랜드</td>
				<td>원산지</td>
				<td>가격</td>
				<td>포인트</td>
				<td>스펙</td>
			</tr>
			<tr>
				<td>${ alcohol.category }</td>
				<td>${ alcohol.brand }</td>
				<td>${ alcohol.country }</td>
				<td>${ alcohol.price }원</td>
				<td>${ alcohol.point }</td>
				<td>${ alcohol.spec }</td>
			</tr>
			<tr>
				<td colspan="6">설명 : ${ alcohol.content }</td>
			</tr>
			<tr>
				<td colspan="7" height="10"></td>
			</tr>
		</c:forEach>
		<tr>
				<td colspan="8" height="20" align="center">${ pageInfo.pagingHtml }</td>
		</tr>
	</table>
</center>
