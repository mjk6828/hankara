<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>

<%
	String uploadPath = request.getRealPath("upload");
	int size = 10 * 1024 * 1024; //(1024 : 1kb) => 10Mbyte
	
	//변수 선언
	String name = "";
	String subject = "";
	String filename1 = "";
	String filename2 = "";
	String origfilename1 = "";
	String origfilename2 = "";
	
	try{
		
		MultipartRequest multi = new MultipartRequest(
				request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy()); 
		//파일이 중복이 되었을 때 자동으로 파일명에 번호가 붙는다(?)
		
		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
		
		Enumeration files = multi.getFileNames();
		//input태그의 속성이 파일일 때 
		//파일 속성이 여러개일 때 항상 쓰임(util)
		String file1 = (String)files.nextElement();
		filename1 = multi.getFilesystemName(file1);
		//파일속성으로 지정된 input태그에 의해서 서버로
		//실제 업로드 파일 이름이 String타입으로 반환된다.
		origfilename1 = multi.getOriginalFileName(file1);
		//사용자가 직접  지정한 파일
		
		String file2 = (String)files.nextElement();
		filename2 = multi.getFilesystemName(file2);
		origfilename2 = multi.getOriginalFileName(file2);
				
	}catch(Exception e){
		e.printStackTrace();
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="fileCheck.jsp" method="post" name="filecheck">
		<input type="hidden" name="name" value="<%=name%>">
		<input type="hidden" name="subject" value="<%=subject%>">
		<input type="hidden" name="filename1" value="<%=filename1%>">
		<input type="hidden" name="filename2" value="<%=filename2%>">
		<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
		<input type="hidden" name="origfilename2" value="<%=origfilename2%>">
	
	</form>
	
	<a href="#" onClick="javascript:filecheck.submit()">
		업로드 확인 및 다운로드 페이지로 이동
	</a>
</body>
</html>