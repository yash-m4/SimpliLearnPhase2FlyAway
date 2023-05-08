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
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletCustomer
 */
@WebServlet("/customer")
public class ServletCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<h3 style='font-family: monospace;'> Welcome to FlyAway </h3>");
		pw.println("<h5> Please select your Source, Destination & Date of Travel</h5>");
		
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		List<FlightDetails> fd=session.createQuery(" from FlightDetails ").list();	
		
		pw.println("<br/>");

		pw.println("<div>");
		pw.println("<form method=post action =customer>");

		String style="style=text-align: center;";

		pw.println("<select name=source>");
		pw.println("<option>Select Source</option>");
		for(FlightDetails f:fd)
		{
			pw.println("<option>"+ f.getSource()+"</option>");
			
		}
		pw.println("</select>");
		
		pw.println("<select name=destination>");
		pw.println("<option>Select Destination</option>");
		for(FlightDetails f:fd)
		{
			pw.println("<option>"+ f.getDestination()+"</option>");
			
		}
		pw.println("</select>");
		
		pw.println("<select name=date>");
		pw.println("<option>Select Date of Travel</option>");
		for(FlightDetails f:fd)
		{
			pw.println("<option>"+ f.getDate()+"</option>");
			
		}
		pw.println("</select>");
		
		
		pw.println("<input type=submit value=Submit id='submit'>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("date");
	
		
		
		String f = "FROM FlightDetails F WHERE F.source ='"+source+"'and F.destination='"+destination+"' and F.date='"+date+"'";
		
		// step 1 build session factory object
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		// step 2 open session
		Session session=sf.openSession();
		List<FlightDetails> fd = session.createQuery(f).list();
		for(FlightDetails ab:fd){
			System.out.println(ab.getSource());
			System.out.println(ab.getDestination());
			System.out.println(ab.getDate());
			
		}
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		if(fd!=null && fd.size()>0){
		pw.println("<h5> Here are the Available Flights </h5>");
		
		pw.println("<br/>");

		pw.println("<div>");
		pw.println("<form method=post action =customer-flight>");

		String style="style=text-align: center;";

		pw.println("<select name=customerFlight>");
		pw.println("<option>Select Flight</option>");
		for(FlightDetails fdd:fd)
		{
			pw.println("<option>"+ fdd.getFlight()+"</option>");
			
		}
		pw.println("</select>");
	
		pw.println("<br/><br/>");
		pw.println("No. of Persons Traveling: <input type=text name=person id=person/>");
		pw.println("<br><br>");
		pw.println("<input type=submit value=Submit id='submit1'>");
		pw.println("</form>");
		pw.println("</div>");
		}
		else{
			pw.println("<h2> No Flights Available for these Selections</h2>");
		}
		pw.println("</body></html>");
	}

}
