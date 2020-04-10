/**
 * 
 * 
 */
var i = 1;
var temp = [];
var asyncRequest; 

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
			    temp.push(element);
			    var vtemp = "valor passado";
			   // var $bt=$('<input/>').attr({type:"button", name:"mybutton", value:"Download", onclick:"showAlert("+ i + ")"});
			
			   // newElement.innerHTML = '<div id=Index'+ i +' >Nome do arquivo '+ fileElements["Index"+ i] + '</div>';	
			   // newElement.innerHTML = ' <a href="C:\TestUpload\Estudar Mais tarde.txt" download="test.txt">Download</a>'
			   /* newElement.innerHTML =  '<form action="FileUploadSV" enctype="multipart/form-data" method="get" >'+		
										'<input type="submit" value="Fazer Download"><br>'+
										'</form>'	*/
			    newElement.innerHTML = '<form action="FileUploadSV" method="get">'	+	
			    						element  +'&nbsp<button type="submit" value='+ fileElements["Index" + i] +' text="download" name="nameValue" >"Download"</button>' +
										'</form>'
			    p.append(newElement);
			    //$('#Index' + i).append($bt);
				i++;
				
			}			
		}
	})	
 });

function showAlert(i){	
	$.ajax({
			url:'testServelt',
			data :{name: temp[i-1]}, 
			type:"POST",
			success:function(r){
				alert(r);
			},
	 });

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


