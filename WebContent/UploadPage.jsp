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

<fieldset class="frame">
	<legend>Upload Files</legend>
		Select the file <input type="file" class="button" id="fileUpload"><br>
		<input type="submit" class="button" id="SubmitToUpload" value="Upload File">	
</fieldset>

<br>

<fieldset class="frame">
<legend>Download Files &nbsp;<input type="submit" class="button" id="RButton" value="Refresh"></legend>


<table id="tableDownload"></table>


</fieldset>

<br>

<form action="Logout">	
	<input type="submit" class="button" value="Log Out" >
</form>


</body>
</html>