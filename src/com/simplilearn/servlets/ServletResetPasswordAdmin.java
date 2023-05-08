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

import com.simplilearn.entity.Admin;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ServletResetPasswordAdmin
 */
@WebServlet("/reset-password-admin")
public class ServletResetPasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletResetPasswordAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(password);
		System.out.println(username);
		
		SessionFactory sf=HibernateUtil.buildSessionFactor();
				Session session =sf.openSession();
			Admin admin=new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			 
			Transaction tx=session.beginTransaction();
			session.save(admin);
			tx.commit();
			session.close();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>");
			pw.println("<h2> New Username And Password has been assigned</h2>");
			pw.println("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
