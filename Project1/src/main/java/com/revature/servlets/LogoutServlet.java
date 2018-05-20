package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("base.html").include(req, resp);
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		pw.println("you are successfully logged out");
		pw.println("</div>");
		pw.println("<a href=\"login.html\">Go back</a>");
		pw.println("</body></html>");
	}

}
