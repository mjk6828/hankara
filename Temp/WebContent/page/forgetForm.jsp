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
<script type="text/javascript" src="../js/script.js"></script>

<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

*{
	font-family: 'Ubuntu';
 }

body, html {
	height: 100%;
	margin-left: 5%;
	margin-right: 5%;
	background-color: #FFFFE0;
}

#form1 {
	position: absolute;
	top: 30%; 
	left: 38%;
	border: 0.8px solid;
	border-radius: 10px;
	padding: 0px 2px 8px 2px;
}

#form2 {
	position: absolute;
	top: 30%; 
	left: 38%;
	border: 0.8px solid;
	border-radius: 10px;
	padding: 0px 2px 8px 2px;
}

#find {
	width: 400px;
	padding: 0;
	display: flex;
}

#type {
	width: 80px;
	height: 45px;
	border: solid 1px;
	border-color: #827ffe;
	margin-right: 2px;
}

#content{
	text-align: center;
}

.title{
	 color:#403866; 
	 padding-bottom: 20px;
	 text-align: center;
}

.txt{
	height: 45px;
	width: 250px;
	color: #403866;
	font-size:25px;
	background-color: #fff;
	border-radius: 3px;
	border:solid 1px;
	border-color:#827ffe;
	padding-left: 10px;
	margin-right: 3px;
}

.btn{
	height: 45px;
	width: 80px;
	font-size: 16px;
	color: #fff;
	border-radius: 3px;
	background-color: #827ffe;
	border:none;
    transition: all .4s;
}

.btn:hover{
	background-color: rgb(106, 90, 205);
}

::placeholder{
	font-size: 20px;
	padding-left: 10px;
}

.logbtn{
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

.logbtn:hover{
	background-color: rgb(106, 90, 205);
}
</style>
</head>
<body>
		<jsp:include page="menu.jsp"/>
		<!-- 아이디 찾기 -->
		<c:if test="${num == 0}">
		<form action="/Temp/membercontrol/ForgetID.do" method="post"
			name="forgetID" id="form1" onsubmit="return FindID()">
			<p><h1 class="title"><b>아이디 찾기</b></h1></p>
			<div class="container" id="find">
				<select id="type" name="id">
					<option value="name">이름</option>
					<option value="email">이메일</option>
				</select>
				<input type="text" name="stext" class="txt" 
				placeholder="입력하세요.." required><br><br>
				<button type="submit" onclick="showID('content');" class="btn">
					<b>전송</b>
				</button>
			</div><br>
			<div id="content">
			<p>
				<c:if test="${check1 eq 0}">
					<b>요청할 데이터를 입력해주세요^^</b>
				</c:if>
				<c:if test="${check1 eq 1}">
					<b>요청하신 아이디는 ${id}입니다.</b><br>
					<button type="button" class="logbtn"
					onclick="document.location.href='/Temp/page/loginForm.jsp'">
					<b>로그인 하기</b>
				</button>
				</c:if>
				<c:if test="${check1 eq 2}">
					<b>아이디가 존재하지 않거나 입력한 정보가 틀렸습니다.</b>
				</c:if>
			</p>
		</div>
		</form>
		</c:if>
		<c:if test="${num == 1}">
		<!-- 비밀번호 찾기 -->
		<form action="/Temp/membercontrol/ForgetPass.do" method="post"
			name="forgetPW" id="form2" onsubmit="return FindID()">
			<p><h1 class="title"><b>비밀번호 찾기</b></h1></p>
			<div class="container" id="find">
				
				<select id="type" name="find">
					<option value="id">ID</option>
					<option value="name">이름</option>
					<option value="email">이메일</option>
				</select>
				<input type="text" name="stext" class="txt" 
				placeholder="입력하세요.." required><br><br>
				<button type="submit" onclick="showID('content');" class="btn">
					<b>전송</b>
				</button>
			</div><br>
			<div id="content">
				<p>
					<c:if test="${check eq 0}">
						<b>요청할 데이터를 입력해주세요^^</b>
					</c:if>
					<c:if test="${check eq 1}">
						<b>요청하신 비밀번호는 ${pass}입니다.</b><br>
						<button type="button" class="logbtn"
						onclick="document.location.href='/Temp/page/loginForm.jsp'">
						<b>로그인 하기</b>
					</c:if>
					<c:if test="${check eq 2}">
						<b>아이디가 존재하지 않거나 비밀번호가 틀렸습니다.</b>
					</c:if>
				</p>
			</div>
		</form>
		</c:if>
	<script type="text/javascript">
		function showID(id) {
			var e = document.getElementById(id);
			
			if(e.style.display == 'none')
				e.style.display = 'block';
			else
				e.style.display = 'none'
		}
	</script>
</body>
</html>
