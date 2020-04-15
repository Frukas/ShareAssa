package com.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

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
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadSV() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
		String printValue = request.getParameter("nameValue");
		  	
    	
    	response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + printValue );
    	FileInputStream ins = new FileInputStream("C:\\TestUpload\\" + printValue);
    	ServletOutputStream out = response.getOutputStream();
    	int i;
    	
    	
		while ((i=ins.read()) != -1) {  
			out.write(i);   
		}
		out.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setHeader("Content-Disposition", "attachment; filename=");
		//response.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-Type", "text/xml;charset=UTF-8");
		
		String path = "C:\\TestUpload\\";
		Part filePart = request.getPart("fileName");		
		String fileName = filePart.getSubmittedFileName();
		int i;
		
		fileName = checkSpacesInString(fileName);				
		OutputStream out = null;
	    InputStream filecontent = null;  	    
	    InputStreamReader isr = null;
	    
	    try{
	    out = new FileOutputStream(new File(path+fileName));
	    filecontent = filePart.getInputStream();	    
	    isr = new InputStreamReader(filecontent, "UTF8");
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    File finalFinal = new File(path+fileName);	    
		while ((i=isr.read()) != -1) {  
			out.write(i); 
			//System.out.println(finalFinal.length());
		} 
		out.close();		
	}
	
	private String checkSpacesInString(String fileName) {
		if(fileName.contains(" ")) {
			fileName = fileName.replace(" ","_");
		}		
		return fileName;		
	}	
}
