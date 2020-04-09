<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FileUploadSV" enctype="multipart/form-data" method="post">
		<input type="File" name="fileName" ><br>
		<input type="submit" value="Fazer Upload"><br>
	</form>	
	
		<form action="FileUploadSV" enctype="multipart/form-data" method="get">
		
		<input type="submit" value="Fazer Download"><br>
	</form>	

</body>
</html>