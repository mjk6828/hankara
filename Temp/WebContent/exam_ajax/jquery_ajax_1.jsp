<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title></title>
<script type="text/javascript">
	$(function(){
		$("#newsWrap_1")
		.load("jquery_ajax_news.jsp #news_1");
		
		$("#newsWrap_2")
		.load("jquery_ajax_news.jsp #news_2");
	});
</script>
</head>
<body>
	<h1>LOAD1</h1>
	<div id="newsWrap_1"></div>
	<h1>LOAD2</h1>
	<div id="newsWrap_2"></div>
</body>
</html>