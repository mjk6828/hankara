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
<link href="../css/regForm.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/regForm.js"></script>

<title>회원가입 페이지</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<form action="/Temp/membercontrol/RegProc.do" 
	name="regform" id="regform" method="post">

		<div class="container" id="register">
			
			<p><h1 class="title"><b>회원가입</b></h1></p>
			<!-- 아이디 -->
			<div style="width : 388px;">
			<input type="text" class="ID" placeholder="아이디" name="id" required>
			<input type="button" value="중복확인" class="btn btn-sm"
			onclick="idCheck(this.form.id.value)"><br><br>
			</div>
			<!-- 비밀번호 -->
			<input type="password" class="PW" placeholder="비밀번호"
				name="pass" required><br><br>
			<input type="password" class="REPW" placeholder="비밀번호 확인"
				name="pass" required><br><br>
			<!-- 이름 -->
			<input type="text" class="NAME" placeholder="이름" name="name" required><br><br>
			<!-- 전화번호 -->
			<div>
				<select name="phone1" class="PHONE1">
					<option value="02">02</option>
               		<option value="031">031</option>
               		<option value="032">032</option>
               		<option value="033">033</option>
				</select>
				&nbsp;<b>-</b>&nbsp;
				<input type="text" name="phone2" class="PHONE">
				&nbsp;<b>-</b>&nbsp;
            	<input type="text" name="phone3" class="PHONE">
			</div><br>
			<!-- 이메일 -->
			<input type="text" class="EMAIL" placeholder="이메일 주소" name="email" required><br><br>
			
			<!-- 우편번호 -->
			<div style="width : 388px;">
			<input type="text" class="ZIPCODE1" placeholder="우편번호" name="zipcode" required>
			<input type="button" value="찾기" class="btn btn-sm"
			onclick="zipCheck()"><br><br>
			</div>
			<!-- 주소1 -->
			<input type="text" class="ZIPCODE" placeholder="주소" name="address1" required><br><br>
			
			<!-- 주소2 -->
			<input type="text" class="ZIPCODE" placeholder="상세주소" name="address2" required><br><br>
			
			<button type="submit" class="regbtn">
				<b>가입하기</b>
			</button>
		</div>
	</form>
</body>
</html>