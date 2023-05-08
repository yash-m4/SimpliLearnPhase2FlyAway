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
 * Servlet implementation class ServletViewDetails
 */
@WebServlet("/view-details")
public class ServletViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check1");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		List<FlightDetails> fd=session.createQuery(" from FlightDetails ").list();
		
		if(fd!=null && fd.size()>0){
			pw.println("<h3> Details </h3>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<th> Sources </th>");
			pw.println("<th> Destinations </th>");
			pw.println("<th> Airlines </th>");
			pw.println("<th> Flights </th>");
			pw.println("<th> Prices </th>");
			pw.println("<th> Dates </th>");
			pw.println("</tr>");
			
			for(FlightDetails f:fd){
				pw.println("<tr>");
				pw.println("<td>" +f.getSource()+ "</td>");
				pw.println("<td>" +f.getDestination()+ "</td>");
				pw.println("<td>" +f.getAirline()+ "</td>");
				pw.println("<td>" +f.getFlight()+ "</td>");
				pw.println("<td>" +f.getPrice()+ "</td>");
				pw.println("<td>" +f.getDate()+ "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("<br/><br/>");
			pw.println("<a href='add-details'> Add More Details </a>");
			pw.println("<br/><br/>");
			pw.println("<a href='admin.html'> Return To Menu </a>");
		}
		else{
			pw.println("<p> There is currently no recored in DataBase </p>");
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
