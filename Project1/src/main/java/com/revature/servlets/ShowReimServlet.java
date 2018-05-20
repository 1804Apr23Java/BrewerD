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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		//Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		Gson objGson = new GsonBuilder().create();
		
		//ObjectMapper m = new ObjectMapper();
		try {
			
			emp = ed.getEmployee((String) session.getAttribute("username"));
			
			reimList = rd.getReimForEmp(emp);
			
			String json = objGson.toJson(reimList);
			
			if(reimList.size() == 0) {
				System.out.println("Null Reimbursement List");
				response.setContentType("html/text");
				response.getWriter().write("No reimbursements.");
				return;
			}
			//String reimString = "";
			//List<Reimbursement> myObjects = m.readValue(reimString, m.getTypeFactory().constructCollectionType(List.class, Reimbursement.class));

			//String reimString = m.writeValueAsString(reimList);

			
			
			// String json = new Gson().toJson(someObject);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//resp.getWriter().write("{\"bears\":"+bearString+"}");
			System.out.println(json);
			response.getWriter().write(json);

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
