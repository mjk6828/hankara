<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>우편번호 검색</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>

<style type="text/css">
*{
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	font-family: 'Ubuntu';
 }
 
.btn{
	height: 62px;
	width: 350px;
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

.searchbtn{
	height: 24px;
	width: 40px;
	color: #fff;
	border-radius: 3px;
	background-color: #827ffe;
	transition: all .4s;
	border:none;
	align-items: center;
}

.searchbtn:hover{
	background-color: rgb(106, 90, 205);
}
</style>

</head>
<body>
	<div align="center">
		<h2><b>우편번호 찾기</b></h2><hr>
		<form name="zipForm" action="../membercontrol/ZipCheckCon.do"
			method="post">
			<input type="hidden" name="check" value="n">
			<label style="font-size:20px;">동 이름 :</label>
			<input type="text" name="dong"> 
			<input type="button" value="검색" class="searchbtn" onclick="dongCheck()">
		</form>
			<c:if test="${check eq 'n'}">
				<c:if test="${zipcodeList.isEmpty()}">
						<br>검색된 결과가 없습니다.<br>
				</c:if>

			<c:if test="${!zipcodeList.isEmpty()}">
				<br>검색 후 아래 우편번호를 클릭하면 자동으로 입력됩니다.<br><br>
				<c:forEach var="vo" items="${zipcodeList}">
				<ul style="padding-left:120px;">
					<li style="text-align: left;">
						<a href="javascript:sendAddress('${vo.getZipcode()}','${vo.getSido()}',
         												'${vo.getGugun()}','${vo.getDong()}',
         												'${vo.getRi()}','${vo.getBunji()}')">
							${vo.getZipcode()}&nbsp; ${vo.getSido()}&nbsp; ${vo.getGugun()}&nbsp;
							${vo.getDong()}&nbsp; ${vo.getRi()}>&nbsp; ${vo.getBunji()} </a>
					</li>
				</ul>
				</c:forEach>
			</c:if>
		</c:if>
		
		<button type="button" class="btn"
		onclick="document.location.href='javascript:this.close();'">닫기</button>
	</div>


</body>
</html>