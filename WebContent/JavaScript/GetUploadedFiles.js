/**
 * 
 * 
 */
var i = 1;
var temp = [];

$(document).ready(function() {
	$.ajax({
		url:'FileListRetriver',
		data :{name:'teste'},
		datatype:'json',
		success:function(fileElements){	
			
			while(fileElements["Index" + i] != null){
				var p = document.getElementById('filelist');
			    var newElement = document.createElement('p');
			    var element = fileElements["Index" + i];
			    temp.push(element);
			    var $bt=$('<input/>').attr({type:"button", name:"mybutton", value:"Download", onclick:"showAlert("+ i + ")"});
			
			    newElement.innerHTML = '<div id=Index'+ i +' >Nome do arquivo '+ fileElements["Index"+ i] + '</div>';
			    p.appendChild(newElement);	
			    $('#Index' + i).append($bt);
				i++;
				
			}			
		}
	})	
 });

function showAlert(i){
	
	alert(temp[i-1]);
}


/*$(document).ready(function() {
	$('#action').click(function(){
		$.ajax({
			url:'FileListRetriver',
			data :{name:'teste'},
			datatype:'json',
			success:function(fileElements){							
			  		   
			    while(fileElements["Index" + i] != null){
				    var p = document.getElementById('filelist');
				    var newElement = document.createElement('p');
				    newElement.innerHTML = '<div id=Index'+ i+ ' >Nome do arquivo '+ fileElements["Index"+ i] + '</div>';
				    p.appendChild(newElement);			    
				    i++;
				 }			   
			}
		});
	});
});*/


