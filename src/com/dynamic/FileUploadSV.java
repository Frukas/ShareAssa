package com.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;

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
		
		String path = "C:\\TestUpload\\";
		Part filePart = request.getPart("fileName");
		String fileName = filePart.getSubmittedFileName();
		
		int i;		
		OutputStream out = null;
	    InputStream filecontent = null;
	    PrintWriter writer = response.getWriter();
	   // response.setHeader("Content-Disposition", "attachment; filename="+filePart.getSubmittedFileName());
	  //  writer.println(filePart.getSubmittedFileName().toString());
	  
	    
	    
	    try{
	    out = new FileOutputStream(new File(path+fileName));
	    filecontent = filePart.getInputStream();
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		while ((i=filecontent.read()) != -1) {  
			out.write(i);   
		} 
		out.close();
	}

}
