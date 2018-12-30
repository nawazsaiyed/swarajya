<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="com.gvp.swarajya.Category"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<html>
<head>
	<title>Swarajya</title>
	<%@include file="head.html" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 mx-auto">
			<img src="images/swarajlogo.png" class="img-fluid" style="width: 100%" />
		</div>
	</div>
	<div class="row">
		
		<div class="col-md-4 mx-auto" >
			<form method="get" action="search-result.jsp" class="form-inline">
				<div class="form-group">
			      	<input type="search" class="form-control form-control-md"  placeholder="Enter Search text">
			    	<button type="submit" class="btn btn-primary" style="margin-left:10px;">Search</button>
			    </div>
			</form>
		</div>
	</div>
	<div class="container">	
	<div class="row">
		<%
			Configuration conf = new Configuration().configure().addAnnotatedClass(Category.class);
			ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
			SessionFactory factory = conf.buildSessionFactory(registry);
			Session hibernSession = factory.openSession();
			Transaction tx = hibernSession.beginTransaction();
			String hql = "FROM Category";
			Query query = (Query) hibernSession.createQuery(hql);
			List<Category> categories =  query.list();
			
			tx.commit();
		%>
		<% for(Category category : categories){ %>
		
		<div class="card mb-3 col-md-3 category" style="padding:0px;">
			<a href="sub-category.jsp?ref=1&id=<%=category.getId()%>">
			  <h3 class="card-header" style="margin:0px;"><%=category.getCategoryName() %></h3>
			  <img style="margin:0px auto;height: 150px; width: 200px; display: block;" src="images/icons/<%=category.getCategoryIcon() %>" alt="Farm Production">
			</a>
		</div>
		<% } %>
		
	</div>
</div>
</body>
</html>
