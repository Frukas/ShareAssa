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
				var d = document.getElementById('fileDelete');
			    var newElement = document.createElement('p');
			    var newDeleteElement = document.createElement('d');
			    var element = fileElements["Index" + i];
			    			    			 			    
			  
			    newElement.innerHTML = '<div class="grid-item">'+  element  +'&nbsp<button type="submit" value='+ element +' text="download" name="nameValue" >"Download"</button></div>';
 			    newDeleteElement.innerHTML = '<div class="grid-item">'+  element  + '&nbsp<button type="submit" value='+ element +' text="Delete" name="nameDelete" >"Delete"</button></div>';
			    p.append(newElement);	
			    d.append(newDeleteElement);
				i++;				
			}			
		}
	})	
 });




