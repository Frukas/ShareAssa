package com.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadSV
 */
@WebServlet("/FileUploadSV")
@MultipartConfig
public class FileUploadSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * File Download Function
     */
    public FileUploadSV() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	    	    	
		String printValue = request.getParameter("nameValue");
		String jvalue = URLEncoder.encode(printValue,"UTF-8");		 
			
		response.setCharacterEncoding("UTF8");
    	response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + jvalue );
		
		FileInputStream ins = new FileInputStream("C:\\ShareAssaFolder\\" + printValue );
		if(ins == null) {
			response.sendRedirect("DownloadErrorPage.jsp");
		}    	
    	ServletOutputStream out = response.getOutputStream();
    	int i;
    	
    	
		while ((i=ins.read()) != -1) {  
			out.write(i);   
		}
		out.close();
    }

	/**
	 * File Upload Function
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File tempFile = null;
		File finalFile = null;
		
		String path = "C:\\ShareAssaFolder\\";
		Part filePart = request.getPart("fileObject");		
		String fileName = new String(request.getParameter("filename").getBytes("iso-8859-1"), "UTF-8");
		int i;		
		
		fileName = checkSpacesInString(fileName);
		fileName = checkDuplicate(fileName,fileName , 0);			
		
		OutputStream out = null;
	    InputStream filecontent = null;  	    
	    InputStreamReader isr = null;
	    
	    try{
		    tempFile = new File( path + fileName + ".tmp");
		    finalFile = new File( path + fileName );
		    out = new FileOutputStream(tempFile);
		    filecontent = filePart.getInputStream();	    
		    isr = new InputStreamReader(filecontent, "UTF8");
		    
		    while ((i=isr.read()) != -1) {  
				out.write(i);				
			}		    
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }	   
		
		out.close();
		tempFile.renameTo(finalFile);
		
	}
	
	private String checkSpacesInString(String fileName) {
		if(fileName.contains(" ")) {
			fileName = fileName.replace(" ","_");
		}		
		return fileName;		
	}	

	
	
	private String checkDuplicate(String nameInitial, String namefinal, int i ) throws UnsupportedEncodingException {
		CheckUploadFolder cuf = new CheckUploadFolder();
		Map <String ,String> map = new HashMap<String , String>();
		String existingFileUTF8 = URLEncoder.encode(namefinal,"UTF-8");
		String newFileName = nameInitial.substring(0, nameInitial.length()-4) +"_" + i  + nameInitial.substring(nameInitial.length()-4, nameInitial.length());
			
		map = cuf.checkFiles();
		
		if(map.containsValue(existingFileUTF8) || map.containsValue(namefinal) ) {	
			i++;			
			return checkDuplicate(nameInitial, newFileName, i);			
		}
		
		return namefinal;
	}
	
}
