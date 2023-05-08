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
 * Servlet implementation class ServletCustomerFlight
 */
@WebServlet("/customer-flight")
public class ServletCustomerFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCustomerFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerFlight=request.getParameter("customerFlight");
		String person=request.getParameter("person");
		int p=Integer.valueOf(person);
		PrintWriter pw=response.getWriter();
		
		System.out.println(p);
		System.out.println(customerFlight);
		
		SessionFactory sf=HibernateUtil.buildSessionFactor();
		
		Session session=sf.openSession();
		
		List<FlightDetails> fd=session.createQuery(" FROM FlightDetails F WHERE F.flight ='"+customerFlight+"' ").list();	
		
		
		pw.println("<html><body>");
		pw.println("<h3> You Have Chosen Flight "+customerFlight+"</h3>");
		for(FlightDetails f:fd){
			String price=f.getPrice();
			int pr=Integer.valueOf(price);
			int amt=pr*p;
		pw.println("<h3>Price for "+p+" persons is : "+amt+".00 Rupees"+"</h3>");
	   
	
		}
		
			
			pw.println("<form method=post action = person-details>");
			for(int i=1;i<=p; i++){
			pw.println("<fieldset>");
			pw.println("<legend> Enter Person details </legend>");
			pw.println("<br/>");
			pw.println("Name: <input type=text name='pname"+i+"' id='pname'/> <br/><br/>");
			pw.println("Age: <input type=text name='age"+i+"' id='age'/> <br/><br/>");
			
			pw.println("<select name='gender"+i+"'>");
			pw.println("<option value=Male>Male</option>");
			pw.println("<option value=Female>Female</option>");
			pw.println("<option value=Others>Others</option>");
			pw.println("</select>");
			
			
			}
		
		pw.println("<input type=submit value=Submit id='submit'>");
		
		
		pw.println("</fieldset>");
		pw.println("<input type='hidden' id='pcheck' name='pcheck' value='"+p+"'>");
		pw.println("</form>");
		
		pw.println("</body></html>");

	}
}
