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

import com.simplilearn.entity.Admin;
import com.simplilearn.util.HibernateUtil;


/**
 * Servlet implementation class ServletAdminLogin
 */
@WebServlet("/admin-login")
public class ServletAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("admin-login.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		PrintWriter pw=response.getWriter();
			String f = "FROM Admin E WHERE E.username =";
			String a="'";
			String b="'";
			String c="and E.password =";
			String hql=f+a+username+b+c+a+password+b;
			// step 1 build session factory object
			SessionFactory sf=HibernateUtil.buildSessionFactor();
			// step 2 open session
			Session session=sf.openSession();
			List<Admin> admin = session.createQuery(hql).list();
			if(admin.isEmpty()){
				pw.println("<h1>please enter correct username and password</h1>");
			}
			else{
				response.sendRedirect("admin.html");
			}
	
	}

}
