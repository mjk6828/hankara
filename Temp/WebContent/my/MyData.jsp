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
	<h5><c:out value="${loginID}" />님의 마이페이지 입니다.</h5>
	
	<div class="memberMenubar">
		<div class="memberMenu">
		<a href="/Temp/my/MyPage.jsp">내 정보</a> <br>
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
	<c:if test="${result eq 1}">
	<div class="container">
		<div class="data">
			<table class="table" style="border: 1px solid #dddddd">
				<tbody>
					<tr>
						<th id="title" style="text-align:center;">아이디</th>
						<th style="text-align:center;"><c:out value="${loginID}" /></th>
					</tr>
		
					<tr>
						<th id="title" style="text-align:center;">이름</th>
						<th style="text-align:center;">${vo.name}</th>
					</tr>
					<tr>
						<th id="title" style="text-align:center;">이메일</th>
						<th style="text-align:center;">${vo.email}</th>
					</tr>
					<tr>
						<th id="title" style="text-align:center;">휴대폰</th>
						<th style="text-align:center;">${vo.phone1}-${vo.phone2}-${vo.phone3}</th>
					</tr>
					<tr>
						<th id="title" style="text-align:center;">우편번호</th>
						<th style="text-align:center;">${vo.zipcode}</th>
					</tr>
					<tr>
						<th id="title" style="text-align:center;">주소</th>
						<th style="text-align:center;">${vo.address1}</th>
					</tr>
					<tr>
						<th id="title" style="text-align:center;">상세주소</th>
						<th style="text-align:center;">${vo.address2}</th>
					</tr>
				</tbody>
			</table>
			<button class="btn btn-primary" type="button" onClick="location.href='/Temp/membercontrol/ModifyForm.do'">회원정보수정</button> 
			<button class="btn btn-primary" type="button" onClick="location.href='/Temp/page/main.jsp'">메인페이지</button>
		</div>
	</div>
	</c:if>
	<c:if test="${result eq 0}">
		<h5>비밀번호가 틀렸습니다</h5>
	</c:if>
</div>
</body>
</html>