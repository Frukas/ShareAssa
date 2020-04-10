/**
 * 
 * 
 */
var i = 1;


$(document).ready(function() {
	$.ajax({
		url:'FileListRetriver',
		data :{name:'teste'},
		datatype:'json',
		type:"GET",
		success:function(fileElements){	
			
			while(fileElements["Index" + i] != null){
				var p = document.getElementById('filelist');
			    var newElement = document.createElement('p');
			    var element = fileElements["Index" + i];
			    
			    			 			    
			    newElement.innerHTML = element  +'&nbsp<button type="submit" value='+ fileElements["Index" + i] +' text="download" name="nameValue" >"Download"</button>'
			    p.append(newElement);			    
				i++;				
			}			
		}
	})	
 });




