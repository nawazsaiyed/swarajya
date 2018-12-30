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

public class UserLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session hibernateSession = factory.openSession(); 
		Transaction tx = hibernateSession.beginTransaction();
		String hql = "from User where email = :email AND password = :password";
		Query query = hibernateSession.createQuery(hql);
		query.setParameter("email", request.getParameter("email").trim());
		query.setParameter("password", request.getParameter("password").trim());
		
		User user = (User) query.uniqueResult();
		tx.commit();
		hibernateSession.close();
		if(user != null)
		{
			HttpSession servletSession = request.getSession(true);
			servletSession.setAttribute("loginUser", user);
			response.sendRedirect("index.jsp");
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			request.setAttribute("loginstatus", false);
		}
	}
}
