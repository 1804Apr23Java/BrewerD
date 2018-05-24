package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2625346607120644446L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("username") != null) {
			//System.out.println("Current user: " + session.getAttribute("username"));
			req.getRequestDispatcher("ShowProfileServlet").forward(req, resp);
			return;
		} else {
			resp.sendRedirect("login");
			return;
		}
	}

}
