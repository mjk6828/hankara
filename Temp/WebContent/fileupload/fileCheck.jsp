<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String filename1 = request.getParameter("filename1");
	String filename2 = request.getParameter("filename2");
	String origfilename1 = request.getParameter("origfilename1");
	String origfilename2 = request.getParameter("origfilename2");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 확인 및 다운로드 파일</title>
</head>
<body>

	올린 사람 :	<%=name %><br>
	제목 :		<%=subject %><br>
	파일명1 :	<img src="../upload/<%=filename1%>" width="200" height="200"><br>
	파일명2 :	<img src="../upload/<%=filename2%>" width="200" height="200">
	
</body>
</html>