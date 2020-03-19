<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Score Board</title>
<jsp:include page="include/Header.jsp"></jsp:include>
<style type="text/css">
.dropdown{
float:left;
margin-right:5px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<span>검색일자</span> <input type="date" size="5"> <span>부터</span>
				<input type="date" size="5"> <span>까지</span>
			</div>
			<div class="panel-body">
				<span style="float:left;">영화</span>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Dropdown <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
				</div>
				<span style="float:left;">영화</span>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Dropdown <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
				</div>
				<span style="float:left;">영화</span>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Dropdown <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
				</div>
				<span style="float:left;">영화</span>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Dropdown <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
				</div>
				<span style="float:left;">영화</span>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Dropdown <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
				</div>
				
				<button class="btn btn-primary" style="float:rigth;">검색</button>
			</div>
		</div>
	</div>
</body>
</html>