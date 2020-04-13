/**
 * 
 */

$(document).ready(function(){	
		
	divUpdate();	

	$('#RButton').click(function(){
		$('#filePanel').load('UploadPage.jsp #filePanel',function(){
			divUpdate();
		});			
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
					$('#filePanel').load('UploadPage.jsp #filePanel',function(){
						divUpdate();
					});
					
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

function LineGenerator(fileElements){
		
	var i = 1;
	
	while(fileElements["Index" + i] != null){
		var p = document.getElementById('filelist');
		var d = document.getElementById('fileDelete');
	    var newElement = document.createElement('p');
	    var newDeleteElement = document.createElement('d');
	    var element = fileElements["Index" + i];
	    			    			 			    
	  
	    newElement.innerHTML = '<div class="grid-item">'+  element  +'&nbsp<button type="submit" value='+ element +' text="download" name="nameValue" >"Download"</button></div>';
		newDeleteElement.innerHTML = '<div class="grid-item">'+  element  + '&nbsp<button type="submit" value='+ element +' text="Delete" name="nameDelete" >"Delete"</button></div>';
		newDeleteElement.addEventListener("click", deleteFile.bind(this, element));
		p.append(newElement);	
	    d.append(newDeleteElement);
		i++;				
	}		
}

function deleteFile(element){
	$(document).ready(function(){
		$.get("FileDelete",{nameDelete:element}, function(data){
			alert(data);
		});
	});	
}

