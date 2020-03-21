<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.StudentDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 체크</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/script.js"></script>

<style type="text/css">
.btn{
	height: 62px;
	width: 350px;
	font-size: 16px;
	color: #fff;
	border-radius: 3px;
	background-color: #827ffe;
	
	border:none;
    justify-content: center;
    align-items: center;
    padding: 0 20px;
    margin-top:20px;
    transition: all .4s;
}

.btn:hover{
	background-color: rgb(106, 90, 205);
}	
</style>

</head>
<body>
	<div class="text-center">
		<h2><b>아이디 중복확인</b></h2><hr>
		<b style="font-size:20px;">${id}</b>
		<c:if test="${check eq true}">는 이미 존재하는 ID입니다.</c:if>
		<c:if test="${check ne true}">는 사용 가능한 ID입니다.</c:if><br>
		<button type="button" class="btn"
		onclick="document.location.href='javascript:this.close();'">닫기</button>
	</div>
	

</body>
</html>