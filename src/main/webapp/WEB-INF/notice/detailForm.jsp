<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../mall/main_top.jsp"%>
<!-- detailForm.jsp -->
<br>
<script>
	function del(num, pageNumber) {
		var chk = confirm("삭제하시겠습니까?");
		if (chk) {
			location.href = "delete.no?num=" + num + "&pageNumber=" + pageNumber;
		}
	}

</script>

<center>
	<h2>${notice.subject}</h2>
	<hr>
	<br>
	<table>
		<tr height="200" valign="top">
			<td align="center"><br>${notice.content}</td>
		</tr>
		<c:if test="${notice.image != null}">
			<tr>
				<td align="center"><img height=auto width=700
					onclick="javascript:popupImage(this.src);"
					src="<%=request.getContextPath()%>/resources/${notice.image}">
				</td>
			</tr>
		</c:if>
		<tr>
			<!-- admin으로 로그인시 -->
			<c:choose>
				<c:when test="${fn:contains(loginInfo.id, 'admin')}">
					<td align="center" colspan="2"><br> <br> <input
						type="button" value="글수정"
						onClick="location.href='update.no?num=${notice.num}&pageNumber=${pageNumber}'">
						<input type="button" value="글삭제"
						onClick="del('${notice.num}','${pageInfo.pageNumber }')">
						<input type="button" value="글목록"
						onClick="document.location.href='list.no?pageNumber=${pageNumber}'">
					</td>
				</c:when>
				<c:otherwise>
					<td align="center" colspan="2"><input type="button"
						value="글목록"
						onClick="document.location.href='list.no?pageNumber=${pageNumber}'">
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</center>
<%@ include file="../mall/main_bottom.jsp"%>