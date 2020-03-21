<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>게시판 리스트</title>
<link href="../css/boardForm.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<!-- ---------------------- 게시판 영역 ---------------------- -->
	<div class="container" style="width: 75%; padding:2% 5% 2% 5%;">
		<ul class="nav nav-tabs nav-justified" role="tablist">
			<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					게임 커뮤니티<span class="caret"></span></a>
				<ul class="dropdown-menu" style="text-align: center; width: 100%;">
					<li><a href="#">게임1</a></li>
					<li><a href="#">게임2</a></li>
					<li><a href="#">게임3</a></li>
					<li><a href="/Temp/control/BoardList.do">자유게시판</a></li>
				</ul>
			</li>
			<li><a href="#">임시공간</a></li>
			<li><a href="#">공지사항</a></li>
		</ul>
	</div>
	<br>
	<br>
	<c:if test="${count==0}">
		<table class="table table-bordered table-hover">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>

	<div class="container" style="padding:1% 0% 1% 0%;">
		<c:if test="${count > 0}">
			<table class="table table-bordered table-hover">
				<thead style="background-color: #827ffe">
					<tr>
						<th style="width: 10%;">번호</th>
						<th style="width: 40%;">제목</th>
						<th style="width: 10%;">작성자</th>
						<th style="width: 10%;">날짜</th>
						<th style="width: 10%;">조회수</th>
						<th style="width: 10%;">글종류</th>
						<th style="width: 5%;">추천</th>
						<th style="width: 5%;">반대</th>
					</tr>
				</thead>
				<c:forEach var="article" items="${articleList}">
					<tbody>
						<tr>
							<td align="center">
								<c:out value="${number}" /> 
								<c:set var="number" value="${number -1}" />
							</td>

							<td>
								<c:if test="${article.depth > 0}">
									<img src="../images/level.gif" width="${5*article.depth}"
										height="16"></img>
									<img src="../images/re.gif"></img>
								</c:if> 
								<c:if test="${article.depth==0 }">
									<img src="../images/level.gif" width="${5*article.depth}"
									height="16"></img>
								</c:if>
								
								<a href="../control/BoardInfo.do?num=${article.num}&pageNum=${currentPage}">
								${article.subject}</a>

								<c:if test="${article.readcount >= 10 }">
									<img src="../images/hot.gif" border="0" height="16"></img>
								</c:if>
							</td>

							<td align="center" width="100">
								<a href="mailto.${article.email}">${article.writer }</a>
							</td>
							<td>${article.regdate}</td>
							<td align="center">${article.readcount }</td>
							<td align="center">
							<c:choose>
								<c:when test="${article.b_type == 'free'}">
									<span class="label label-primary">자유게시판</span>
								</c:when>
								<c:when test="${article.b_type == 'culture'}">
									<span class="label label-info">문화</span>
								</c:when>
								<c:when test="${article.b_type == 'hobby'}">
									<span class="label label-danger">취미</span>
								</c:when>
								<c:when test="${article.b_type == 'qna'}">
									<span class="label label-success">Q&A</span>
								</c:when>
							</c:choose>
							
							</td>
							<td align="center" width="20">${like}</td>
							<td align="center" width="20">0</td>
						</tr>

					</tbody>
				</c:forEach>
			</table>
		</c:if>
		<br><br>

		<!--  검색 창 넣기 -->
		<div class="container" style="padding:2% 100px 2% 0px; align-content: center;">
			<form class="text-center" name="i_frm" method="post"
				action="../control/BoardList.do" onsubmit="return check()">
				<select name="find" value="${find}" size="1" id="select">
					<option value="writer">이름</option>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select> 
				<input type="text" class="search" name="find_box"
					placeholder="Search..">
				<c:if test="${loginID ne null}">	
				<a class="btn btn-default pull-right" id="btn-write"
					href="../control/BoardWriteForm.do">글쓰기</a>
				</c:if>
				<c:if test="${loginID eq null}">
				<a class="btn btn-default pull-right" id="btn-write"
					href="/Temp/page/loginForm.jsp">글쓰기</a>
				</c:if>
			</form>

		</div>
		<hr>

		<c:if test="${count > 0 }">
			<div class="text-center" style="text-align: center;">
				<ul class="pagination" style="height: 34px;">
					<c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1 }" />
					<fmt:parseNumber var="pageCount" value="${count/pageSize+imsi}"
						integerOnly="true" />
					<c:set var="pageBlock" value="${3}" />
					<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}"
						integerOnly="true" />
					<c:set var="startPage" value="${result * pageBlock + 1 }" />
					<c:set var="endPage" value="${startPage + pageBlock-1}" />
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
					<c:if test="${startPage > pageBlock}">

						<li><a
							href="/Temp/control/BoardList.do?pageNum=${startPage - pageBlock }"
							onClick="frm_sub(${startPage - pageBlock })">&nbsp;&laquo;이전</a></li>
					</c:if>

					<c:forEach var="i" begin="${startPage }" end="${endPage}">
						<li><a href="/Temp/control/BoardList.do?pageNum=${i} "
							onClick="frm_sub(${i})">${i}</a></li>
					</c:forEach>

					<c:if test="${endPage < pageCount }">
						<li><a
							href="/Temp/control/BoardList.do?pageNum=${startPage + pageBlock}"
							onClick="frm_sub(${startPage + pageBlock })">다음&nbsp;&raquo;</a>
						<li>
					</c:if>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>