package com.gvp.swarajya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AdminLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		Configuration config = new Configuration().configure().addAnnotatedClass(Admin.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session hibernateSession = factory.openSession(); 
		Transaction tx = hibernateSession.beginTransaction();
		String hql = "from Admin where email = :email AND password = :password";
		Query query = hibernateSession.createQuery(hql);
		query.setParameter("email", request.getParameter("email").trim());
		query.setParameter("password", request.getParameter("password").trim());
		
		Admin admin = (Admin) query.uniqueResult();
		tx.commit();
		hibernateSession.close();
		if(admin != null)
		{
			HttpSession servletSession = request.getSession(true);
			servletSession.setAttribute("loginUser", admin);
			response.sendRedirect("index.jsp");
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginstatus", false);
		}
	}
}
