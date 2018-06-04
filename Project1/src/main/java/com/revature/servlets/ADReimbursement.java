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
import com.revature.Dao.ReimbursementDao;
import com.revature.Dao.ReimbursementDaoImpl;
import com.revature.base.Employee;
import com.revature.base.Reimbursement;

/**
 * Servlet implementation class ADReimbursement
 */
public class ADReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ADReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ADReim doPost");
		
		HttpSession session = request.getSession();
		
		String manager = (String) session.getAttribute("username");
		Employee emp;
		Reimbursement reim;
		EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		
		try {
			emp = ed.getEmployee(manager);
			int man_id = emp.getEmp_id();
			
					
			Integer reimbursementId = new Integer (request.getParameter("reimbursementId"));
			Integer approveDeny = new Integer (request.getParameter("approveDeny"));
			
			reim = rd.getReimbursement(reimbursementId);
			
			System.out.println("ADReim updating...");
			
			
			if (approveDeny == 1) {
				System.out.println("Approved.");
				rd.approveReimbursement(reim, man_id);
			} else if (approveDeny == 2) {
				System.out.println("Denied.");
				rd.denyReimbursement(reim, man_id);
			}
			
			response.sendRedirect("home");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
