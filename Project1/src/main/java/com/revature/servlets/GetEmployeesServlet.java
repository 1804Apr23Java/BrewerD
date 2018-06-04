package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.base.Employee;

/**
 * Servlet implementation class PReimServlet
 */
public class GetEmployeesServlet extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 3929483794526190954L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//HttpSession session = request.getSession(false);
		
		EmployeeDao ed = new EmployeeDaoImpl();
		//ReimbursementDao rd = new ReimbursementDaoImpl();
		//Employee emp;
		
		List<Employee> empList;
		
		try {
			
			//emp = ed.getEmployee((String) session.getAttribute("username"));
			
			empList = ed.getEmployees();
			
			String strList = "";
			
			if(empList.size() == 0) {
				System.out.println("Null Emp List");
				response.setContentType("html/text");
				response.getWriter().write("No Employees.");
				return;
			}
			
			
			for(Employee em : empList) {
				strList += em.toString();
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(strList);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GET EMPLOYEES Servlet doPost");

		//HttpSession session = request.getSession(false);
		
		EmployeeDao ed = new EmployeeDaoImpl();
		//ReimbursementDao rd = new ReimbursementDaoImpl();
		//Employee emp;
		List<Employee> empList;
		
		try {
			
			//emp = ed.getEmployee((String) session.getAttribute("username"));
			
			empList = ed.getEmployees();
			
			String strList = "";
			
			if(empList.size() == 0) {
				System.out.println("Null Emp List");
				response.setContentType("html/text");
				response.getWriter().write("No Employees.");
				return;
			}
			
			
			for(Employee em : empList) {
				strList += em.toString();
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(strList);
			response.getWriter().write(strList);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
