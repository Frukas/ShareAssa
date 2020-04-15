/**
 * 
 */

$(document).ready(function(){	
		
	divUpdate();	

	$('#RButton').click(function(){
		updateTable();		
	});	
	
	$('#SubmitToUpload').click(function(){
		
		var file = $('#fileUpload')[0].files[0]
		
		if(file == null){
			alert("Arquivo não selecionado");			
		}else{
		var fd = new FormData();		
		fd.append('fileName', file);		
			$.ajax({
				url:'FileUploadSV',
				data : fd, 	
				contentType: false,
				processData: false,
				type:"POST",
				success:function(){	
					alert("Upload com sucesso");				
					updateTable();
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
		var newElement = tabeRowS.insertCell(0);
		var newDeleteElement = tabeRowS.insertCell(1);
		var element = fileElements["Index" + i];
	 	    
	newElement.innerHTML = '<form action="FileUploadSV">' + element  +'&nbsp<button type="submit" value='+ element +' text="download" name="nameValue" >Download</button>';
	newDeleteElement.innerHTML = '<button type="submit" value='+ element +' text="Delete" name="nameDelete" >Delete</button>';
	newDeleteElement.addEventListener("click", deleteFile.bind(this, element));
	i++;				
	}		
}

function deleteFile(element){
	$(document).ready(function(){
		$.get("FileDelete",{nameDelete:element}, function(data){
			alert(data);
			updateTable();
		});
	});	
}


