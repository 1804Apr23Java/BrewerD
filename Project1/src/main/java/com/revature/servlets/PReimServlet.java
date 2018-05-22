package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class PReimServlet
 */
public class PReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PReimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("PENDING SERVLET doGet");

		HttpSession session = request.getSession(false);
		
		//EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		//Employee emp;
		List<Reimbursement> reimList;
		
		try {
			
			//emp = ed.getEmployee((String) session.getAttribute("username"));
			
			reimList = rd.getPendingReimbursements();
			
			String strList = "";
			
			if(reimList.size() == 0) {
				System.out.println("Null Pending Reimbursement List");
				response.setContentType("html/text");
				response.getWriter().write("No reimbursements.");
				return;
			}
			
			
			for(Reimbursement r : reimList) {
				strList += r.toString();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("PENDING SERVLET doPost");
		HttpSession session = request.getSession(false);
		
		//EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		//Employee emp;
		List<Reimbursement> reimList;
		
		try {
			
			//emp = ed.getEmployee((String) session.getAttribute("username"));
			
			reimList = rd.getPendingReimbursements();
			
			String strList = "";
			
			if(reimList.size() == 0) {
				System.out.println("Null Pending Reimbursement List");
				response.setContentType("html/text");
				response.getWriter().write("No reimbursements.");
				return;
			}
			
			
			for(Reimbursement r : reimList) {
				strList += r.toString();
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
