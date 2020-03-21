<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loginID" value="${sessionScope.loginID }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapesd"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Temp/control/Main.do"> <i class="fa fa-home"></i>
				</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs=example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class=""><a onclick="#">소개<span class="sr-only"></span></a></li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						 role="button" aria-haspopup="true" aria-expanded="false">
						 	문화<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">패션</a></li>
							<li><a href="#">음악</a></li>
							<li><a href="#">영화</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">취미<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">맛집</a></li>
							<li><a href="#">여행</a></li>
							<li><a href="#">도서</a></li>
						</ul></li>

					<li><a href="/Temp/control/BoardList.do">자유게시판</a></li>
				</ul>

				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="검색어...">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>


				<c:choose>
					<c:when test="${loginID ne null}">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false"><c:out value="${loginID }" />님<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/Temp/my/MyPage.jsp">마이페이지</a></li>
								</ul>
							</li>
						</ul>

					</c:when>
					<c:when test="${loginID eq null }">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">접속하기<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/Temp/membercontrol/Login.do">로그인</a></li>
									<li><a href="/Temp/membercontrol/RegForm.do">회원가입</a></li>
								</ul>
							</li>
						</ul>
					</c:when>
				</c:choose>
			</div>
		</div>
	</nav>
</body>
</html>