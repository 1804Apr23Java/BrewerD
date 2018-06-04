package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.Dao.ReimbursementDao;
import com.revature.Dao.ReimbursementDaoImpl;
import com.revature.base.Employee;
import com.revature.base.Reimbursement;

/**
 * Servlet implementation class ReimsForEmpServlet
 */
public class ReimsForEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimsForEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ReimsForEmp doGet");
		
		HttpSession session = request.getSession(false);


		EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		
		Employee emp = null;
		
		try {
			
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()) {
				System.out.println(e);
			}
			
			System.out.println("Trying to grab Integer..." + request.getParameter("employeeID"));
			
			Integer empid = Integer.parseInt(request.getParameter("employeeID"));
			
			System.out.println("Integer: " + empid);
			
			emp = ed.getEmployeeById(empid);
			
			System.out.println("ReimsForEmp emp: " + emp.toString());
			
			List<Reimbursement> rl = rd.getReimForEmp(emp);
			
			String strList = "";
			
			for(Reimbursement r : rl) {
				System.out.println("r: " + r);
				strList += r.toString();
				
			}
			
			System.out.println("ReimsForEmp is returning: " + strList);
			
			response.getWriter().write(strList);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ReimsForEmp doPost");
		
		HttpSession session = request.getSession(false);


		EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		
		Employee emp = null;
		
		try {
			emp = ed.getEmployeeById((int)session.getAttribute("emp_id"));
			List<Reimbursement> rl = rd.getReimForEmp(emp);
			
			String strList = "";
			
			for(Reimbursement r : rl) {
				System.out.println("r: " + r);
				strList += r.toString();
				
			}
			
			System.out.println("ReimsForEmp is returning: " + strList);
			
			response.getWriter().write(strList);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
