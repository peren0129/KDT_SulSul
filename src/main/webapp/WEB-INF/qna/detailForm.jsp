<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
detailForm.jsp
<br>
<%-- <%=application.getRealPath("/resources")%> <br>
<%=application.getContextPath()%><br> 
<%=request.getContextPath()%><br> --%>
<script>
	function del(num,pageNumber) {
		var chk = confirm("삭제하시겠습니까?");
		if (chk) {
			location.href="delete.qna?num="+num+"&pageNumber="+pageNumber;
		}
	}	
	
	/*  
	function popupImage(url){
	    var img = new Image();
	    var scWidth = screen.availWidth; //현재 사용중인 스크린 크기를 구함
	    var scHeight = screen.availHeight;
	    var left = (parseInt(scWidth)-650)/2; //팝업창 위치 조절
	    var top = (parseInt(scHeight)-900)/2;
	    img.src = url;
	    var img_width = img.width-500; //팝업창 크기 조절
	    var win_width = img.width-500;
	    var height = img.height-290;
	    var openImage = window.open('','_blank','width='+img_width+',height='+heigh',top='+top+',left='+left+',menubars=no,scrollbars=auto');
	    openImage.document.write("<style>body{margin:0px;}</style><a href = # onclick = window.close() onfocus=this.blur()><img src = '"+url+"'width='"+win_width+"'></a>");
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
		<tr height="200" valign="top">
			<td><br>본문</td>
			<td><br>${qna.content}</td>
		</tr>
		<tr>
			<td valign="top">첨부파일</td>
			<td> <c:if test="${qna.image != null}"><img height=300 width=300 onclick="javascript:popupImage(this.src);" 
						src="<%=request.getContextPath()%>/resources/${qna.image}"></c:if> 
			<c:if test="${qna.image == null}"><small> 첨부된 파일이 없습니다.</small></c:if><br><br>
			</td>
		</tr>
		<tr>
		
		</tr>
		<tr>
			<!-- 관리자 아이디로 로그인시 ~~ 로 수정  -->
			<c:if test="${fn:contains(qna.writer, '길동')}">
				<table border="1" width="840px" id="reply_area"
					bordercolor="#DCDCDC">
					<tr reply_type="all" style="display: none">
						<!-- 뒤에 댓글 붙이기 쉽게 선언 -->
						<td colspan="4"></td>
					</tr>

					<!-- 임시 -->
					<tr
						reply_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>">
						<!-- 댓글의 depth 표시 -->
						<td width="800px">&thinsp;&thinsp;주문번호 또는 스크린샷 첨부 부탁드립니다.</td>

						<td align="center" width="200px">
							<button name="reply_reply" parent_id="${replyList.reply_id}"
								reply_id="${replyList.reply_id}">답글</button> <!-- 첫 댓글에만 댓글이 추가 대댓글 불가 -->

							<button name="reply_modify" parent_id="${replyList.parent_id}"
								r_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>"
								reply_id="${replyList.reply_id}">수정</button>
							<button name="reply_del"
								r_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>"
								reply_id="${replyList.reply_id}">삭제</button>
						</td>
					</tr>
					<!------------->



					<c:forEach var="replyList" items="${replyList}" varStatus="status">
						<tr
							reply_type="<c:if test="${replyList.depth == '0'}">main</c:if><c:if test="${replyList.depth == '1'}">sub</c:if>">
							<!-- 댓글의 depth 표시 -->
							<td width="800px"><c:if test="${replyList.depth == '1'}"> → </c:if>${replyList.reply_content}
							</td>
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
				<table border="1" bordercolor="#DCDCDC">
					<tr valign="bottom" align="center">
						<td colspan="2"><textarea id="reply_content"
								name="reply_content" rows="4" cols="100"
								placeholder="댓글을 입력하세요."></textarea></td>
						<td width="100px">
							<button id="reply_save" name="reply_save">댓글 등록</button>
						</td>
					</tr>
				</table>

				<!--
						<input type="button" value="답변하기" onClick="location.href='reply.qna?num=${qna.num}&pageNumber=${pageNumber}'" >
						<input type="button" value="답변완료" onClick="comp()">  이거할라면 form필요
				-->
			</c:if>
		</tr>
		
		<tr>
		
			<td align="center" colspan="2"><br><br><input type="button" value="글수정"
				onClick="location.href='update.qna?num=${qna.num}&pageNumber=${pageNumber}'">
				<input type="button" value="글삭제"
				onClick="del('${qna.num}','${pageInfo.pageNumber }')"> <%-- onClick="location.href='delete.qna?num=${qna.num}&pageNumber=${pageNumber}'"> --%>
				<%-- <input type="button" value="답글쓰기" onClick="location.href='reply.bd?ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'" > --%>
				<input type="button" value="글목록"
				onClick="document.location.href='list.qna?pageNumber=${pageNumber}'">
			</td>
		</tr>

		<tr>
		</tr>
	</table>
</center>
