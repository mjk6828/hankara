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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="../css/main.css" rel="stylesheet" type="text/css">
<link href="../css/news.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/news.js"></script>

<title>커뮤니티 사이트</title>

</head>
<body>
	
	<button onclick="topFunction()" id="myBtn">Top</button>
	
	<jsp:include page="menu.jsp"/>
	
	<div class="container" style="padding-left: 0; padding-right: 0; padding-top: 0%; padding-bottom: 2%;
	margin-left: 0%; margin-right: 0%; width:auto;">
		<div class="jumbotron" style="margin-left: 0; margin-right: 0;">
			<h1 class="text-center">게임 커뮤니티 사이트</h1>
			<p class="text-center">게임 정보 및 Tip을 공유하는 
			커뮤니티 사이트입니다.</p>
			
			<!-- 공지사항 -->
			<div style="margin-left: 45%;">
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">공지사항</button>

				
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- 공지사항 내용 -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									&times;</button>
								<h4 class="modal-title">여기는 머리말 부분</h4>
							</div>
							<div class="modal-body">
								<p>여기는 본문입니다.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success"
									data-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<!-- 최신뉴스 -->
	<div class="container" style="width:1500px; padding: 0% 2% 0% 12%;">
		<div class="row">
			<h3>최신게임뉴스</h3>
			<div class="customDiv">
				<div class="widget_page_index_0 widget_page_item active">
					<ul class="col-md-6 img-responsive">
						<li class="col-md-5 img-responsive" data-index="0">
							<a class="link" target="_self"
							href="http://www.inven.co.kr/webzine/news/?news=222793&site">
							<div class="box0">
								<img src="../news/dota2.jpg">
								<div class="content">
									<h3>도타2 : 개막 두 달 앞둔 도타2 TI9, 총상금 255억 돌파</h3>
								</div>
							</div>
							</a>
						</li>
						<li class="col-md-5 img-responsive" data-index="1">
							<a class="link" target="_self"
							href="https://mainia.tistory.com/2836">
							<div class="box1">
								<img src="../news/over2.jpg">
								<div class="content">
									<h3>같은 포지션은 두 명씩, '역할 고정' 기능 테스트 서버 적용</h3>
								</div>
							</div>
							</a>
						</li>
						<li class="col-md-5 img-responsive" data-index="2">
							<a class="link" target="_self"
							href="https://mainia.tistory.com/2836">
							<div class="box2">
								<img src="../news/dun2.jpg">
								<div class="content">
									<h3>캐릭터 밸런스 패치는 이제 끝? 신규 패키지 판매</h3>
								</div>
							</div>
							</a>
						</li>
						<li class="col-md-5 img-responsive" data-index="3">
							<a class="link" target="_self"
							href="https://mainia.tistory.com/2836">
								<div class="box3">
									<img src="../news/has2.jpg">
									<div class="content">
										<h3>드로우와 하수인 소환 콤보! "범람"과 "아누비사스 문지기"</h3>
									</div>
								</div>
							</a>
						</li>
						<li class="col-md-5 img-responsive" data-index="4">
							<a class="link" target="_self"
							href="https://mainia.tistory.com/2836">
								<div class="box4">
									<img src="../news/lol_zac.jpg">
									<div class="content">
										<h3>'뚜루뚜빠라빠'! 궁극기 돌아온 자크, 랭크 상위권 지속중</h3>
									</div>
								</div>
							</a>
						</li>
						<li class="col-md-5 img-responsive" data-index="5">
							<a class="link" target="_self"
							href="https://mainia.tistory.com/2836">
								<div class="box5">
									<img src="../news/wow2.jpg">
									<div class="content">
										<h3>'벌' 탈것 등장!! 개발자 노트로 보는 8.2.5 PTR 변경점</h3>
									</div>
								</div>
							</a>
						</li>
					</ul>
					<ul class="topcol">
						<div class="inner" id="news1">
							<img src="../news/dota44.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
						<div class="inner" id="news2">
							<img src="../news/dun.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
						<div class="inner" id="news3">
							<img src="../news/wow.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
						<div class="inner" id="news4">
							<img src="../news/hearths.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
						<div class="inner" id="news5">
							<img src="../news/lol.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
						<div class="inner" id="news6">
							<img src="../news/over.jpg"
								class="col-md-2 img-responsive img-thumbnail" />
						</div>
					</ul>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<h4>이 게시판의 특징</h4>
					<p>이 커뮤니사이트는 다른 사이트와 차원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기
						쉽도록 정교하게 구성되었습니다.</p>
					<p>
					<a class="btn btn-success" data-target="#modal"
					data-toggle="modal">자세히 알아보기</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- 인기 게시글 모음 -->
	<div class="container" style="padding:0 0;">
		<br>
		<div class="row">
			<div class="col-sm-6">
				<h4 style="text-align: center;">인기글 모음 </h4>
				<div class="list-group">
					<c:if test="${count > 0}">
						<c:forEach var="article" items="${articleList}">
							<c:if test="${article.readcount  > 3}"><!-- 조회수 3이상인 경우 게시글에 올림 -->
								<a
									href="../control/BoardInfo.do?num=${article.num}&pageNum=${currentPage}"
									class="list-group-item">${article.subject}&nbsp;&nbsp;&nbsp;
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
									</c:choose> <span class="badge">${article.readcount }</span>
								</a>
							</c:if>
						</c:forEach>
					</c:if>
				</div>
			</div>
			
			<div class="col-sm-6">
				<h4 style="text-align: center;">최신글 모음</h4>
				<div class="list-group">
					<c:if test="${count > 0}">
						<c:forEach var="article" items="${articleList}">
							<a href="../control/BoardInfo.do?num=${article.num}&pageNum=${currentPage}"
							class="list-group-item">${article.subject}&nbsp;&nbsp;&nbsp;
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
							<span class="badge">${article.readcount }</span></a>
						</c:forEach>
					</c:if>				
				</div>
			</div>
		</div>
	</div>
	


	<!-- 여기는 넣을지 말지 아직은 모르기 때문에 보류~~~ -->
	<div class="container text-center">
		<h3>웹 개발자를 소개합니다.</h3>
		
		<p>커뮤니티 사이트를 만든 사람들~~!!</p>
		<br>
		<div class="row">
			<div class="col-sm-3">
				<p class="text-center">
					<strong>도경환</strong>
				</p>
				<br> <a href="#demo" data-toggle="collapse"> <img
					src="../images/teemo.jpg" class="img-circle person"
					width="255" height="255">
					<!-- 가능하면 255X255를 추천 -->
				</a>
				<div id="demo" class="collapse">
					<p>이분은 누구죠?</p>
					<p>도경환입니다.</p>
					<p>현재 그린컴퓨터아카데미에 다니고 있습니다.</p>
				</div>
			</div>
			<div class="col-sm-3">
				<p class="text-center">
					<strong>한승연</strong>
				</p>
				<br> <a href="#demo2" data-toggle="collapse"> <img
					src="../images/olaf.jpg" class="img-circle person"
					width="255" height="255">
				</a>
				<div id="demo2" class="collapse">
					<p>이분은 누구죠?</p>
					<p>한승연입니다.</p>
					<p>현재 그린컴퓨터아카데미에 다니고 있습니다.</p>
				</div>
			</div>
			<div class="col-sm-3">
				<p class="text-center">
					<strong>이세진</strong>
				</p>
				<br> <a href="#demo3" data-toggle="collapse"> <img
					src="../images/master_Yi.jpg" class="img-circle person"
					width="255" height="255">
				</a>
				<div id="demo3" class="collapse">
					<p>이분은 누구죠?</p>
					<p>이세진입니다.</p>
					<p>현재 그린컴퓨터아카데미에 다니고 있습니다.</p>
				</div>
			</div>
			<div class="col-sm-3">
				<p class="text-center">
					<strong>이준기</strong>
				</p>
				<br> <a href="#demo4" data-toggle="collapse"> <img
					src="../images/blit.jpg" class="img-circle person"
					width="255" height="255">
				</a>
				<div id="demo4" class="collapse">
					<p>이분은 누구죠?</p>
					<p>이준기입니다.</p>
					<p>현재 그린컴퓨터아카데미에 다니고 있습니다.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 여기까지 보류~~~!! -->
	


	<!-- 풋터 -->
	<footer>
		<p class="text-center">Copyright &copy; GAMEGUY FACTORY All Rights
			Reserved.</p>
	</footer>
</body>
</html>