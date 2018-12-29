package com.gvp.swarajya;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AddCategory extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Configuration config = new Configuration().configure().addAnnotatedClass(Category.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session hibernateSession = factory.openSession();
		Transaction tx = hibernateSession.beginTransaction();
		String hql = "SELECT max(id) FROM Category";
		Query query = hibernateSession.createQuery(hql);
		Integer last = (Integer)query.list().get(0);
		Category category = new Category();
		if(last == null)
			category.setId(1);
		else
			category.setId(last+1);
		
		category.setCategoryName(request.getParameter("name"));
		category.setCategoryIcon("category"+category.getId()+".png");
		
		hibernateSession.save(category);
		
		tx.commit();
		hibernateSession.close();
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		request.setAttribute("message", "Category Successfully Added");
		dispatcher.forward(request, response);
	}
	
	

}
