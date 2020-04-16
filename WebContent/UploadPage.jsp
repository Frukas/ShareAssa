<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<script src="https://code.jquery.com/jquery-1.10.2.js"	type="text/javascript"></script>
<script src="JavaScript/UploadFile.js" type="text/javascript" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="CSS/StyleUploadPage.css" media="screen" />
<%
	
	//response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	//if(session.getAttribute("auth") == null){
			//response.sendRedirect("Login.jsp");
		//}	 
%>

<head>

<meta charset="utf-8">
<title>ShareAssa</title>
</head>
<body>
<h1>ShareAssa</h1>

<div id="LoadScreen">
	<img src="img/esperas_saltitantes.gif" height="50" width="50" style="float:middle">
</div>

<fieldset>
<h2>Upload Files</h2>
		Escolha o arquivo <input type="file" id="fileUpload"><br>
		<input type="submit" id="SubmitToUpload" value="Upload File">	
</fieldset>
<br>
<br>	
	<input type="submit" id="RButton" value="Refresh">	
<br>
<br>
<p>------------------------------------------------------------------------</p>
<h2>FILES</h2>

<h3>Name</h3>
<table id="tableDownload"></table>
<tr>

</tr>

<br>
<p>------------------------------------------------------------------------</p>

<form action="Logout">	
		<input type="submit" value="Log Out" >
</form>


</body>
</html>