package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.Dao.ReimbursementDao;
import com.revature.Dao.ReimbursementDaoImpl;
import com.revature.base.Employee;
import com.revature.base.Reimbursement;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ShowReimServlet
 */
public class ShowReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ShowReimServlet doGet");
		
		HttpSession session = request.getSession(false);
		
		EmployeeDao ed = new EmployeeDaoImpl();
		ReimbursementDao rd = new ReimbursementDaoImpl();
		Employee emp;
		List<Reimbursement> reimList;

		try {
			
			emp = ed.getEmployee((String) session.getAttribute("username"));
			
			reimList = rd.getReimForEmp(emp);

			String strList = "";
			
			System.out.println("ShowReimServlet Output: ");
			for(Reimbursement r : reimList) {
				System.out.println(r.toString());
			}

			
			if(reimList.size() == 0) {
				System.out.println("Logged In Emp Has No Reimbursements");
				response.setContentType("html/text");
				response.getWriter().write("No reimbursements.");
				return;
			}
			
			
			for(Reimbursement r : reimList) {
				strList += r.toString();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
