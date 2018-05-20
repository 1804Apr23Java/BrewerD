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
import com.revature.base.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp;

		System.out.println("LoginServlet doPost");

		HttpSession session = request.getSession();
		response.setContentType("text/html");

		// PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		try {

			if (ed.isEmployee(username, password)) {
				System.out.println("Valid employee");
				emp = ed.getEmployee(username, password);


				if (ed.isManagerEmployee(emp)) {
					System.out.println("Logging in as manager...");
					session.setAttribute("username", username);
					session.setAttribute("emp_id",  emp.getEmp_id());
					session.setAttribute("problem", null);
					response.sendRedirect("home.jsp");
					
					return;


				} else if (ed.loginEmployee(username, password)) {
					System.out.println("Logging in as employee...");
					session.setAttribute("username", username);
					session.setAttribute("emp_id", emp.getEmp_id());
					session.setAttribute("problem", null);
					//response.sendRedirect("home.jsp");
					//new jsp code below
					response.sendRedirect("home.jsp");
					return;
				}
			} else {
				System.out.println("Not valid");
				session.setAttribute("problem", "incorrect password");
				response.sendRedirect("login");
				return;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
