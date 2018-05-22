package com.revature.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6057117928413353392L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LogoutServlet doPost");
		request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/login.html");
	
	}

	/*
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LogoutServlet doGet");

        HttpSession session = request.getSession();
        session.invalidate();
        //response.setStatus(response.SC_MOVED_TEMPORARILY);
      //  response.setHeader("Location", "login.html");
        
        response.sendRedirect("http://localhost:8083/Project1/login.html");
		
		/*
		response.setContentType("text/html");
		// PrintWriter pw = resp.getWriter();
		request.getRequestDispatcher("login.html").include(request, response);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login.html");
		return;
		*/
		// }
	//}
	
}

