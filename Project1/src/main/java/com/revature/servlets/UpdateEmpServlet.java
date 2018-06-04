package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;

/**
 * Servlet implementation class UpdateEmpServlet
 */
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		EmployeeDao emp = new EmployeeDaoImpl();
		response.setContentType("text/html");
		try {
			String username = (String) session.getAttribute("username");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String password = request.getParameter("pword");
			String email = request.getParameter("email");
			
			emp.updateEmployee(username, firstname, lastname, password, email);
			
			response.sendRedirect("home");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
