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
		//get the current Session or a null
		HttpSession session = req.getSession(false);
		//check whether a Session exists
		
		//System.out.println("In ProfileServlet doGet");
		
		if (session != null && session.getAttribute("username") != null) {
			//System.out.println("Current user: " + session.getAttribute("username"));
			//System.out.println("Employee Id: " + session.getAttribute("emp_id"));
			req.getRequestDispatcher("ShowProfileServlet").forward(req, resp);
			return;
		} else {
			resp.sendRedirect("login");
			return;
		}
	}

}
