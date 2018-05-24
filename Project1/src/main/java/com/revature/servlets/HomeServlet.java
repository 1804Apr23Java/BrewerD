package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2625346607120644446L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the current Session or a null
		HttpSession session = req.getSession(false);
		//check whether a Session exists
		
		if (session != null && session.getAttribute("username") != null) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

}
