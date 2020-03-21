<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginID" value="${sessionScope.loginID }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/memberMenu.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../page/menu.jsp"/>
<div class="container">
	<h1><c:out value="${loginID}" />님의 마이페이지 입니다.</h1>
	<div class="memberMenubar">
		<div class="memberMenu">
		<a href=/Temp/my/MyPage.jsp>내 정보</a> <br>
		</div>
		<div class="memberMenu">
	
	<a href="/Temp/control/MyComment.do?id=${loginID}">내 댓글</a> <br>
	<a href="/Temp/control/MyScrap.do?id=${loginID}">스크랩</a> <br>
		</div>
		<div class="membercontrolMenu">
	
	<a href="/Temp/membercontrol/DeleteForm.do">회원탈퇴</a> <br>
	<a href="/Temp/membercontrol/Logout.do">로그아웃</a> <br>
		</div>
	</div>
	<div class="container">
		<div class="data">
		<br>
		<form action="/Temp/membercontrol/PassCheck.do" method="post">
			<input type="password" name="password" value="password" size="20">
			<input type="hidden" name="loginID" value="${loginID}">
			<button class="btn btn-primary" type="submit">입력</button>
			<br>
			<h4>본인확인을 위해 비밀번호를 입력해주세요</h4>
		</form>
		</div>
	</div>
</div>

</body>
</html>