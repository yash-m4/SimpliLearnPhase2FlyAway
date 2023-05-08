package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.FlightDetails;
import com.simplilearn.entity.Persons;
import com.simplilearn.util.HibernateUtil;
import com.simplilearn.servlets.ServletCustomerFlight;

/**
 * Servlet implementation class ServletPayment
 */
@WebServlet("/payment")
public class ServletPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String customerFlight=request.getParameter("customerFlight");
		pw.println("<html><body>");
		pw.println("<h1>Confirm Details</h1>");
		pw.println("<br/><br/>");
		pw.println("<p> Following are the persons booked </p>");

		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		List<Persons> ps=session.createQuery(" FROM Persons ").list();	
		pw.println("<h3>Persons Details</h3>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>Persons name</th>");
		pw.println("<th>Persons age</th>");
		pw.println("<th> Gender</th>");
		pw.println("</tr>");
		
		
		
		for(Persons p:ps){
			pw.println("<tr>");
			pw.println("<td>"+p.getName()+"</td>");
			pw.println("<td>"+p.getAge()+"</td>");
			pw.println("<td>"+p.getGender()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		
		pw.println("<br/><br/>");
		pw.println("<a href='confirm-payment.html'> Click here for Payment </a>");
		pw.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
