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
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/boardInfo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>

<script type="text/javascript">
	 window.onload =function(){
	        commentSearchFunction();
	    }
	</script>
<title>글보기 페이지</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div class="container">
		<h1 class="text-center"><b>게시글</b></h1>
		<table class="table table-bordered">
			<tr height="30">
				<td id="title" width="130px"><b>글번호</b></td>
				<td id="text" width="240px">${article.num}</td>
								
				<td id="title" width="100px"><b>글종류</b></td>
				<td id="text" width="240px">${article.b_type}</td>
				
				<td id="title" width="100px"><b>조회수</b></td>
				<td id="text" width="240px">${article.readcount}</td>
			</tr>
			
			<tr height="30">
				<td id="title" width="130px"><b>작성자</b></td>
				<td id="text" width="240px" colspan="3">${article.writer}</td>
				
				<td id="title" width="100px"><b>작성일</b></td>
				<td id="text" width="250px">${article.regdate}</td>
			</tr>
			
			<tr height="30">
				<td id="title" width="130px"><b>제목</b></td>
				<td id="text" width="240" colspan="3">${article.subject}</td>
				<td id="title" width="150px"><b>추천/반대</b></td>
				<td id="text" width="120">${like}/${hate}</td>
			</tr>
			
			<tr height="30">	
				<td id="title" width="130"><b>내용</b></td>
				<td id="text" width="490px" colspan="5">${article.content}</td>
			</tr>
		</table>
		<input type="hidden" id="PaNum" value="${article.num}">
		<input type="hidden" id="loginID" value="${sessionScope.loginID}">
		<input type="hidden" id="pageNum" value="${pageNum}">
		<div class="pull-left">
            <button class="btn btn-primary" type="button" id="good" onclick="likesFunction();" value="Good">추천!</button>
            &nbsp;&nbsp;&nbsp;
            <button class="btn btn-primary" type="button" id="bad" onclick="hatesFunction();" value="Bad">안 추천!</button>
            &nbsp;&nbsp;&nbsp;
            <button class="btn btn-primary" type="button" id="scrap" onclick="scrapFunction();" value="Scrap">스크랩</button>
         </div>
         
         
		<div  class="infobtn">
			<input type="button" class="btn btn-default" value="글수정"
			onclick="document.location.href='../control/BoardUpdate.do?num=${article.num}&pageNum=${pageNum}'">
			<input type="button" class="btn btn-default" value="글삭제"
			onclick="document.location.href='../control/BoardDeleteForm.do?num=${article.num}&pageNum=${pageNum}'">
			<input type="button" class="btn btn-default" value="답글"
			onclick="document.location.href='../control/BoardWriteForm.do?num=${article.num}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'">
			<input type="button" class="btn btn-default" value="글목록"
			onclick="document.location.href='../control/BoardList.do'">
		</div>
		<br><br><br>
		<div>
			<table class="table" style="border: 1px solid #dddddd">
				<thead>
					<tr>
						<th id="title" style="text-align:center;">작성자</th>
						<th id="title" style="text-align:center;">내용</th>
						<th id="title" style="text-align:center;">작성시간</th>
					</tr>
				</thead>
				<tbody style="text-align:center;" id="commentTable">
				</tbody>
			</table>
		
		</div>
		
	<div><button class="btn btn-primary pull-right" type="button" id="commentsearch" 
	onclick="commentSearchFunction();"><h5>새로운 댓글 확인하기</h5></button></div>
	<br><br><br>
	
	
	<div>
		
		
            <h2 align="center">Comment</h2>
            
               <label>작성자 :</label>&nbsp;<span style="font-size:25px;"><c:out value="${loginID}"></c:out></span>&nbsp;&nbsp;
             
      
               <br><br>
               <div style="display: inline-flex;">
               <textarea rows="3" cols="57" id="commentContent"></textarea>&nbsp;&nbsp;&nbsp;
            	
               <button class="btn btn-primary" type="button" onclick="commentFunction();">등록</button></div>
         	
        
        
         </div>
         <br><br>
	</div>
	
</body>
</html>