<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
writeForm.jsp
<br>
<script type="text/javascript">
	/* function write() {
	 if (confirm("등록하시겠습니까 ?") == true) {
	 alert("문의글이 등록되었습니다.");
	 location.href = "write.qna";
	 } else {
	 return;
	 }
	 }  */

	function back() {
		if (confirm("목록으로 돌아가시겠습니까?") == true) {
			location.href = "list.qna";
		} else {
			return;
		}
	}
</script>
<style type="text/css">
.err {
	color: red;
	font-weight: bold;
}
</style>

<center>
	<h2>QNA</h2>
	<form:form commandName="qna" action="write.qna" method="post"
		enctype="multipart/form-data">
	<hr style="width: 1000;">
	<table border="0">
			<tr>
				<td>카테고리</td>
				<td><select name="cate">
						<option value="회원/정보관리">회원/정보관리</option>
						<option value="배송">배송</option>
						<option value="반품/환불/교환/AS">반품/환불/교환/AS</option>
						<option value="영수증/증빙서류">영수증/증빙서류</option>
						<option value="상품/이벤트">상품/이벤트</option>
						<option value="기타">기타</option>
				</select> <form:errors cssClass="err" path="cate" /></td>
			</tr>
			<tr>
				<td>공개여부</td>
				<td><select name="cateopen">
						<option value="전체공개">전체공개
						<option value="비밀글">비밀글
				</select></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" size="30" maxlength="10" name="writer"
					value="${qna.writer }"></td>
				<!-- 로그인 정보로 변경, 수정불가 -->
			</tr>
			<tr>
				<td>* 제목</td>
				<td><input type="text" name="subject" value="${qna.subject }">
					<form:errors cssClass="err" path="subject" /></td>
			</tr>
			<tr>
				<td>* 본문</td>
				<td><textarea name="content" rows="10" cols="50"
						placeholder="내용을 작성해주세요.">${qna.content }</textarea> <form:errors
						cssClass="err" path="content" /></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="upload" value="">${qna.image }</td>
			</tr>
			<tr>
				<td>자동등록방지</td>
				<td>
				
				
				<!-- 
				<form action="/board/write" id="writeForm" method="post">
					<fieldset>
						<legend class="screen_out">게시글 작성 폼</legend>
				
						<div class="box captcha">
							<div class="loading"></div>
							// .loading
				
							<label for="captcha">자동 방지 코드</label>
							<input type="text" id="captcha" name="captcha" autocomplete="off" required />
							<img src="/captcha" alt="캡차 이미지" title="클릭시 새로고침" />
						</div>
						// .box.captcha
				
						<div class="box btn">
							<a href="/board" class="btn cancel">취소</a>
							<button type="submit" class="btn write">작성 완료</button>
						</div>
					</fieldset>
				</form>
				<script>
					var $captchaLoader = $("#writeForm .box.captcha .loading");
					var $captchaImg = $("#writeForm .box.captcha img");
				
					// captcha 새로고침
					$captchaImg.click(function() {
						$captchaLoader.show();
						$(this).attr("src", "/captcha?ran=" + Math.random());
						$captchaLoader.fadeOut(500);
					});
				</script>
			 -->
			
			
				</td>
			</tr>
		</table>

		<input type="button" value="이전" onclick="back()">
		<input type="submit" value="등록">
	</form:form>
	<!-- 	<input type="submit" value="등록" onclick="insert()"> -->

</center>