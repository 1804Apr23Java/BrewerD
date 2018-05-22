package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Dao.*;
import com.revature.base.Employee;

/**
 * Servlet implementation class ShowProfileServlet
 */
public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println("ShowProfileServlet doGet");

		HttpSession session = request.getSession(false);

		//ObjectMapper m = new ObjectMapper();

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp;

		try {
			emp = ed.getEmployee((String) session.getAttribute("username"));

			//String empString = m.writeValueAsString(emp);

			//System.out.println("empString passed back: "+empString);

			// String json = new Gson().toJson(someObject);
			response.setContentType("html/text");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(emp.toString());

			// response.setContentType("application/json");
			// response.addHeader("eString", empString);
			// response.getWriter
			// request.getRequestDispatcher("profile").forward(request, response);
			//return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ShowProfileServlet doPost");

		HttpSession session = request.getSession(false);

		ObjectMapper m = new ObjectMapper();

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp;

		try {
			emp = ed.getEmployee((String) session.getAttribute("username"));

			String empString = m.writeValueAsString(emp);

			System.out.println(empString);

			// String json = new Gson().toJson(someObject);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(empString);

			// response.setContentType("application/json");
			// response.addHeader("eString", empString);
			// response.getWriter
			// request.getRequestDispatcher("profile").forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
