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

/**
 * Servlet implementation class SubmitReimServlet
 */
public class SubmitReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReimServlet() {
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

			System.out.println("SubmitReimServlet doPost");
			
			HttpSession session = request.getSession();
			
			//Reimbursement r;
			ReimbursementDao rd = new ReimbursementDaoImpl();
			EmployeeDao ed = new EmployeeDaoImpl();
			
			try {
				
				Employee emp = ed.getEmployee((String) session.getAttribute("username"));
				
				System.out.println("Grabbed Employee");
				
				
				Double val = new Double(request.getParameter("val"));
				System.out.println("val: " + val);
				
				
				String desc = request.getParameter("des");
				
				System.out.println("desc: " + desc);
				
				String img = request.getParameter("rec");
				
				System.out.println("Submitting Reim...");
				rd.insertReimbursement(desc, img, emp.getEmp_id(), val);
				response.sendRedirect("home");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
