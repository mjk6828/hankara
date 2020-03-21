<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script type="text/javascript" src="../js/script.js"></script>
<title>회원탈퇴</title>
</head>
<body onload="begin()">
	<jsp:include page="menu.jsp"/>
	<form action="../membercontrol/DeleteProc.do" name="myForm" id="deleteform"
		method="post" onsubmit="return.checkIt()">

		<div class="container" id="delete">
			<p><h1 class="title"><b>회원 탈퇴</b></h1></p>
			<input type="password" class="PW" 
			placeholder="비밀번호를 입력하세요." name="pass" required><br><br>
			<button type="submit" class="btn">
				<b>탈퇴하기</b>
			</button>
			<button class="btn" onclick="javascript:window.location='/Temp/page/main.jsp'">
				<b>취소</b>
			</button>
		</div>
		
	</form>
</body>
</html>