<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<script src="https://code.jquery.com/jquery-1.10.2.js"	type="text/javascript"></script>
<script src="JavaScript/UploadFile.js" type="text/javascript"></script>


<head>
<meta charset="ISO-8859-1">
<title>ShareAssa</title>
</head>
<body>
<h1>ShareAssa</h1>
		Escolha o arquivo <input type="file" id="fileUpload"><br>
		<input type="submit" id="SubmitToUpload" value="Upload File">	
<br>
	<br>
		
<h1>Files For Download </h1>
<div id="filePanel" class="grid-container">
	<form id="filelist" action="FileUploadSV" method="get">
		
	</form>	
	
	<h1>---------------///---------------</h1>
		
<h1>Delete Files </h1>
	<!--  form id="fileDelete" action="FileDelete" method="post"-->
	<form id="fileDelete">
	
	
	</form>
</div>	
	

</body>
</html>