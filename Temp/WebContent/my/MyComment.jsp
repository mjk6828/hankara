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
	<h1><c:out value="${loginID}" />님의 댓글목록 입니다.</h1>
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
	<div class="container">
		<div class="membercontainer">
		<c:if test="${result eq 1}">
		<c:forEach var="vo" items="${volist}"> <!-- 배열을 가져올 때는 foreach로 압축해제! -->
			<table class="table" style="border: 1px solid #dddddd;">
				<thead>
					<tr>
						<th id="title" style="text-align:center;" width="100">글 번호</th>
						<th id="title" style="text-align:center;" width="600">제목</th>
						<th id="title" style="text-align:center;" width="100">작성시간</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th style="text-align:center;">${vo.num}</th>
						<th style="text-align:center;">${vo.subject }</th>
						<th style="text-align:center;" rowspan="2">${vo.regdate }</th>
					</tr>
					<tr>
						<th style="text-align:center;">내 댓글</th>
						<th style="text-align:center;">${vo.content }</th>
					</tr>
				</tbody>
			</table>
			</c:forEach>
			</c:if>
			<c:if test="${result ne 1}">
			<table class="table" style="border: 1px solid #dddddd;">
				<thead>
					<tr>
					
						<th style="text-align:center;" width="600">댓글 목록이 없습니다..</th>
						
					</tr>
				</thead>
				
			</table>
			</c:if>	
		</div>
	</div>
</div>
</body>
</html>