package com.gvp.swarajya;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SignUp extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File fileRepository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		fileFactory.setRepository(fileRepository);

		// Create a new file upload handler
		ServletFileUpload fileUpload = new ServletFileUpload(fileFactory);

		// Parse the request
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for(FileItem item : items)
			{
				if(item.isFormField())
				{
					request.setAttribute(item.getFieldName(), item.getString());
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Configuration config = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Farmer.class).addAnnotatedClass(NGO.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "SELECT max(id) FROM User";
		Query query = session.createQuery(hql);
		Integer last = (Integer)query.list().get(0);
		FileUpload upload = new FileUpload();
		
		if(request.getAttribute("utype").toString().equals("1"))
		{
			Farmer farmer = new Farmer();
			if(last == null)
				farmer.setId(1);
			else
				farmer.setId(last+1);
			
			farmer.setFullName(request.getAttribute("name").toString());
			farmer.setEmail(request.getAttribute("email").toString());
			farmer.setAddress(request.getAttribute("address").toString());
			farmer.setLattitude(Double.parseDouble(request.getAttribute("lattitude").toString()));
			farmer.setLongitude(Double.parseDouble(request.getAttribute("longitude").toString()));
			farmer.setPassword(request.getAttribute("password").toString());

			
			farmer.setPhoto("user"+farmer.getId()+".png");
			request.setAttribute("fileName", farmer.getPhoto());
			upload.uploadFile(request);
			farmer.setPhoneNumber(request.getAttribute("contact").toString());
			session.save(farmer);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginUser", farmer);
		}
		else {
			NGO ngo = new NGO();
			if(last == null)
				ngo.setId(1);
			else
				ngo.setId(last+1);
			ngo.setFullName(request.getAttribute("name").toString());
			ngo.setEmail(request.getAttribute("email").toString());
			ngo.setAddress(request.getAttribute("address").toString());
			ngo.setLattitude(Double.parseDouble(request.getAttribute("lattitude").toString()));
			ngo.setLongitude(Double.parseDouble(request.getAttribute("longitude").toString()));
			ngo.setPassword(request.getAttribute("password").toString());

			ngo.setPhoto("user"+ngo.getId()+".png");
			request.setAttribute("fileName", ngo.getPhoto());
			upload.uploadFile(request);
			ngo.setContactPerson(request.getAttribute("contactPerson").toString());
			ngo.setPhoneNumber(request.getAttribute("contact").toString());
			session.save(ngo);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginUser", ngo);

		}
		request.setAttribute("message","Registration Successful!");
		request.getRequestDispatcher("success.jsp").forward(request, response);
		tx.commit();
		session.close();
	}
}
