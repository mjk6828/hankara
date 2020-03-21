<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- 에디터 -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<script src="lang/summernote-ko-KR.js"></script>

<script type="text/javascript" src="../js/summernote.js"></script>
<link href="../css/writeForm.css" rel="stylesheet" type="text/css">
<title>글수정 폼</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<form action="/Temp/control/BoardUpdateProc.do?pageNum=${pageNum}"
		method="post" id="writeform">
		<h1 class="text-center">수정하기</h1>

		<input type="hidden" name="num" value="${num }"> <input
			type="hidden" name="ref" value="${ref }"> <input
			type="hidden" name="step" value="${step }"> <input
			type="hidden" name="depth" value="${depth }"> <label
			for="country">구분</label> <select id="country" name="b_type">
			<option value="free">자유게시판</option>
			<option value="culture">문화</option>
			<option value="hobby">취미</option>
			<option value="qna">Q&A</option>
		</select> <label>제목</label> <input type="text" id="subject" name="subject"
			value="${article.subject}"> <label>작성자</label> <input
			type="text" id="writer" name="writer" value="${article.writer}">

		<label>이메일</label> <input type="text" id="email" name="email"
			value="${article.email}"> <label>내용</label>
		<textarea id="summernote" name="content" style="height: 200px">${article.content}</textarea>
		
		<label>비밀번호 </label> <input type="password" id="pwd" name="pass">

		<input type="submit" class="pull-right" value="제출"> <input
			type="reset" class="pull-right" value="다시쓰기">
	</form>

</body>
</html>