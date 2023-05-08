package com.simplilearn.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.FlightDetails;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletAddDetails
 */
@WebServlet("/add-details")
public class ServletAddDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-details.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String airline=request.getParameter("airline");
		String flight=request.getParameter("flight");
		String price=request.getParameter("price");
		String date=request.getParameter("date");
		
		FlightDetails fd= new FlightDetails();
		fd.setSource(source);
		fd.setDestination(destination);
		fd.setAirline(airline);
		fd.setFlight(flight);
		fd.setPrice(price);
		fd.setDate(date);
		
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(fd);
		tx.commit();
		session.close();
		
		response.sendRedirect("view-details");
	}

}
