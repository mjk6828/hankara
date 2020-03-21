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
<style type="text/css">

*{
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	font-family: 'Ubuntu';
 }

body, html {
	height: 100%;
	margin-left: 5%;
	margin-right: 5%;
	background-color: #FFFFE0;
}

.table-bordered {
	height: 62px;
	width: 388px;
	position: absolute;
	top: 21%;
	right: 38%;
}

.btn{
	height: 62px;
	width: 388px;
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

<title>아이디/비번 찾기</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>	
	<table class="table table-bordered">
		<tr>
			<td align="center">
				<h2>아이디/비번 찾기</h2>
				<br>
				<button type="submit" class="btn"
					onclick="document.location.href='/Temp/membercontrol/ForgetID.do'">
					<b>아이디 찾기</b>
				</button>
				<button type="submit" class="btn"
					onclick="document.location.href='/Temp/membercontrol/ForgetPass.do'">
					<b>비밀번호 찾기</b>
				</button>
			</td>
		</tr>
	</table>
</body>
</html>