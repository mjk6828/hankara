<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="model.StudentDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>

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
	width: 450px;
	position: absolute;
	top: 21%;
	right: 38%;
	background-color: #ffa579;
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

p{
	font-size: 20px;
}
</style>

<title>회원탈퇴성공</title>
</head>
<meta http-equiv="Refresh" content="3;url=../page/main.jsp">
<body>
	<c:set var="result" value="${result}" />
	<c:if test="${result eq 0 }">
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
			history.go(-1);
		</script>
	</c:if>

	<table class="table table-bordered">
		<tr>
			<td align="center">
				<h2>회원 정보가 삭제되었습니다.</h2>
				<br>
				<p>이용해주셔서 감사합니다.</p>
				<br>
				<p>잠시후 메인화면으로 이동하겠습니다.</p>
			</td>
		</tr>
	</table>

</body>
</html>