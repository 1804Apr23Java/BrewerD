package cherryservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In ResponseServlet doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		
		System.out.println("In ResponseServlet doPost");
		
		Enumeration<String> atts = request.getAttributeNames();
		
		while(atts.hasMoreElements()) {
			String s = atts.nextElement();	
			System.out.println(s + " : " +request.getAttribute(s));
		}
		//display answer with PrintWriter 
		String answer =  (String) request.getAttribute("choice");
		System.out.println("Response Server received: " +answer);
		pw.write("<p style = \"margin:30px\"> You selected: " + answer + " as your favorite era.</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"http://localhost:8083/CherryCoke/cherrynutrition.html\">Thank you for your input!</a></p>");
	}
}