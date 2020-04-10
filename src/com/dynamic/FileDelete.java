package com.dynamic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDelete
 */
@WebServlet("/FileDelete")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String resp = (String) request.getParameter("nameDelete");
		File fileDelete = new File("C:\\TestUpload\\" + resp );
		if(fileDelete.delete()) {
			out.write("deletado");
		}else {
			out.write("Falha ao deletar");
		}				
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String resp = (String) request.getParameter("nameDelete");
		File fileDelete = new File("C:\\TestUpload\\" + resp );
		if(fileDelete.delete()) {
			out.write("deletado");
		}else {
			out.write("");
		}	
	}
}
