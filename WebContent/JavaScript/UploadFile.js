/**
 * 
 */

$(document).ready(function(){
	
	$.ajaxSetup({ cache: false });
	
	divUpdate();	

	$('#RButton').click(function(){
		updateTable();		
	});	
	
	$('#SubmitToUpload').click(function(){
				
		var file = $('#fileUpload')[0].files[0]
		var fileName = file.name;
		
		if(file == null){
			alert("File not Selected");			
		}else{
			document.getElementById("LoadScreen").style.display = "block";
		var fd = new FormData();		
		fd.append('fileObject', file);
		fd.append('filename', fileName )
			$.ajax({
				url:'FileUploadSV',
				data : fd, 	
				contentType: false,
				processData: false,
				type:"POST",
				success:function(){		
					document.getElementById("LoadScreen").style.display = "none";				
					updateTable();	
				},
				error:function(){
					alert("Upload error");
					document.getElementById("LoadScreen").style.display = "none";
				},
			});	
		}
	});	
});

function divUpdate(){
	$.get("FileListRetriver", function(data){		
		LineGenerator(data);		
	},"json");
}

function updateTable(){
	$('#tableDownload').load('UploadPage.jsp #tableDownload',function(){
		divUpdate();
	});
}

function LineGenerator(fileElements){
		
	var i = 0;
	
	while(fileElements["Index" + i] != null){		
		var tableRef = document.getElementById("tableDownload");
	  	var tabeRowS = tableRef.insertRow(i);
		var newNameElement = tabeRowS.insertCell(0);
		var newDownloadElement = tabeRowS.insertCell(1);
		var newDeleteElement = tabeRowS.insertCell(2);
		var element = decodeURIComponent(fileElements["Index" + i]);
		
		newNameElement.innerHTML =  element;		
		
		if(element.indexOf(".tmp") <= 0){	
			newDownloadElement.innerHTML = '<form action="FileUploadSV"><button type="submit" class="button" value='+ element +' text="download" name="nameValue" >Download</button>';
			newDeleteElement.innerHTML = '<button type="submit" class="button" value='+ element +' text="Delete" name="nameDelete" >Delete</button>';
			newDeleteElement.addEventListener("click", deleteFile.bind(this, element));
		}else{			
			newDownloadElement.innerHTML = "Not Ready";
			newDeleteElement.innerHTML = "";
		}
	i++;				
	}		
}

function deleteFile(element){
	$(document).ready(function(){
		$.get("FileDelete",{nameDelete:element}, function(data){			
			updateTable();
		});
	});	
}


