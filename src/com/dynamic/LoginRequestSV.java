package com.dynamic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRequestSV
 */
@WebServlet("/LoginRequestSV")
public class LoginRequestSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRequestSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		String name =(String)request.getParameter("aname");
		String pass =(String)request.getParameter("apassword");
		HttpSession session = request.getSession(); 
		LoginAuthentication loA = new LoginAuthentication();		
		
		if(loA.getAuthentication(name, pass)) {
			response.sendRedirect("UploadPage.jsp");
			session.setAttribute("auth", name);
		}else {
			response.sendRedirect("Login.jsp");
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
