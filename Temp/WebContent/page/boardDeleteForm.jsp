<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/deleteForm.css" rel="stylesheet" type="text/css">

<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
<title>글삭제</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<form action="../control/BoardDeleteProc.do?pageNum=${pageNum }" id="deleteform"
		method="post" name="delForm" onsubmit="return deleteSave()">
		
		<div class="container" id="delete">
			<p><h1 class="title"><b>글 삭제</b></h1></p>
			<input type="password" class="PW" 
			placeholder="비밀번호를 입력하세요." name="pass" required>
			<input type="hidden" name="num" value="${num }">
			<br><br>
			<button type="submit" class="btn">
				<b>삭제</b>
			</button>
			<button class="btn" 
			onclick="document.location.href='../control/BoardList.do?pageNum=${pageNum}'">
				<b>취소</b>
			</button>
		</div>
	</form>


</body>
</html>








