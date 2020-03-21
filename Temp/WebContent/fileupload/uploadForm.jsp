<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>
	<h1>File Upload</h1>
	
	<form action="/Temp/Upload" method="post" enctype="multipart/form-data">
		작성자:<input type="text" name="theAuthor"><br><br>
		파일:<input type="file" name="theFile"><br><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>