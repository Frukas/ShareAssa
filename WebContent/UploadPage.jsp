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
		<div class="grid-container">	
			<div class="grid-item">Texte2 <button type="submit" value="Teste2.txt" text="download" name="nameValue" >"Download"</button></div>
			<div class="grid-item">	Texte3 <button type="submit" value="Teste3.txt" text="download" name="nameValue" >"Download"</button></div>
			<div class="grid-item">	Estudar_Mais_tarde.txt <button type="submit" value="Estudar_Mais_tarde.txt" text="download" name="nameValue" >"Download"</button></div>
		</div>
	</form>	
	
		

</body>
</html>