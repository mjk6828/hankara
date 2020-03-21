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
<link href="../css/modifyForm.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>

<title>회원수정 페이지</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<form action="../membercontrol/ModifyProc.do" method="post" name="regform">
			
		<div class="container" id="register">
			
			<p><h1 class="title"><b>회원수정</b></h1></p>
			<!-- 아이디 -->
			<div style="width : 388px;">
			
				<input type="text" class="ID" value="${id}" name="id" disabled>
				<br><br>
			</div>
			
			<!-- 비밀번호 -->
			
			<input type="password" class="PW" value="${pass}"
				name="pass" required><br><br>
			<input type="password" class="REPW" value="${pass}"
				name="repass" required><br><br>
					
			<!-- 이름 -->
			
			<input type="text" class="NAME" 
			name="name" value="${name}" disabled><br><br>
						
			<!-- 전화번호 -->
			<div>
			
				<select name="phone1" class="PHONE1">
					<option value="02"
					${phone1 eq '02' ? "selected='selected'": 'null'}>02</option>
               		<option value="031"
               		${phone1 eq '031' ? "selected='selected'": 'null'}>031</option>
               		<option value="032"
               		${phone1 eq '032' ? "selected='selected'": 'null'}>032</option>
               		<option value="033"
               		${phone1 eq '033' ? "selected='selected'": 'null'}>033</option>
				</select>
				&nbsp;<b>-</b>&nbsp;
				<input type="text" name="phone2" class="PHONE" value="${phone2}">
				&nbsp;<b>-</b>&nbsp;
            	<input type="text" name="phone3" class="PHONE" value="${phone3}">
			</div><br>
			
			<!-- 이메일 -->
			
			<input type="text" class="EMAIL" 
			name="email" value="${email}" required><br><br>
			
			<!-- 우편번호 -->
			<div style="width : 388px;">
			
			<input type="text" class="ZIPCODE1" name="zipcode" value="${zipcode}" required>
			<input type="button" value="찾기" class="btn btn-sm"
			onclick="zipCheck()"><br><br>
			</div>
			
			<!-- 주소1 -->
			<input type="text" class="ZIPCODE" name="address1" value="${address1}" required><br><br>
			
			<!-- 주소2 -->
			<input type="text" class="ZIPCODE" name="address2" value="${address2}" required><br><br>	
			
			
			<button type="submit" class="modifybtn" onclick="updateCheck()">
				<b>정보 수정</b>
			</button>&nbsp;
			<button type="button" class="modifybtn"
			onClick="document.location.href='javascript:history.go(-1)'">
				<b>취소</b>
			</button>
		</div>			
	</form>

</body>
</html>