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
import org.hibernate.Transaction;

import com.simplilearn.entity.FlightDetails;
import com.simplilearn.entity.Persons;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletPersonDetails
 */
@WebServlet("/person-details")
public class ServletPersonDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		List<Persons> persons=session.createQuery(" from Persons ").list();
		
		if(persons!=null&& persons.size()>0){
			pw.println("<h3> Details of Selected Persons </h3>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<th> Name </th>");
			pw.println("<th> Age </th>");
			pw.println("<th> Gender </th>");
			pw.println("</tr>");
			
			for(Persons p:persons){
				pw.println("<tr>");
				pw.println("<td>" +p.getName()+ "</td>");
				pw.println("<td>" +p.getAge()+ "</td>");
				pw.println("<td>" +p.getGender()+ "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			
			pw.println("<br/><br/>");
			pw.println("<a href='payment'> Click here for Confirmation </a>");
		}
		else{
			pw.println("<p> There is currently no persons Data , please add first</p>");
		}
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcheck=request.getParameter("pcheck");
		int pp=Integer.valueOf(pcheck);
		for(int i=1; i<=pp;i++){
			String name1=request.getParameter("pname"+i);
			String age1=request.getParameter("age"+i);
			String gender1=request.getParameter("gender"+i);
			
			System.out.println(name1);
			System.out.println(age1);
			System.out.println(gender1);
			
			Persons persons=new Persons();
			
			persons.setName(name1);
			persons.setAge(age1);
			persons.setGender(gender1);
			
			SessionFactory sf=HibernateUtil.buildSessionFactor();
			
			Session session=sf.openSession();
			
			Transaction tx=session.beginTransaction();
			
			session.save(persons);
			tx.commit();
			session.close();
		}
		
		response.sendRedirect("person-details");
		
		
		}
		
		
		
		
	}


