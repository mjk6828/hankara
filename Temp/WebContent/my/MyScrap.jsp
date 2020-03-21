<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <c:set var="loginID" value="${sessionScope.loginID }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/memberMenu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<jsp:include page="../page/menu.jsp"/>

<div class="container">
<h1><c:out value="${loginID}" />님의 스크랩목록 입니다.</h1>
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
		<div class="scrapContainer">
		<c:forEach var="vo" items="${volist}">
	
			<table class="table" style="border:1px solid #dddddd;">
				<thead>
					<tr>
						<th id="title" style="text-align:center;" width="100px"><b>글 번호</b></th>
						<th id="title" style="text-align:center;" width="400px"><b>제목</b></th>
						<th id="title" style="text-align:center;" width="100px"><b>작성자</b></th>
						<th id="title" style="text-align:center;" width="200px"><b>작성시간</b></th>
						<th id="title" style="text-align:center;" width="100px">삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th style="text-align:center;">${vo.num}</th>
						<th style="text-align:center;"><a href="../control/BoardInfo.do?num=${vo.num}&pageNum=${vo.pagenum}">${vo.subject}</a></th>
						<th style="text-align:center;">${vo.writer}</th>
						<th style="text-align:center;">${vo.regdate}</th>
						<th style="text-align:center;">	
						<input type="hidden" id="PaNum" value="${vo.num}">
						<input type="hidden" id="loginID" value="${sessionScope.loginID}"><button class="btn btn-primary" type="button"
						onclick="deleteFunction();">삭제</button></th>
					</tr>
				</tbody>
			</table>
				</c:forEach>
		</div>
	</div>
		
	

</div>
</body>
</html>