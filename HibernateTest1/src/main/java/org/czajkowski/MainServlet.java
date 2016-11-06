package org.czajkowski;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 2140922262124061504L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> A very simple servlet example</title>");
		out.println("</head>");
		out.println("<body>");

		SessionFactory sf = new Configuration().
				configure("/hibernate.cfg.xml").
				buildSessionFactory();

		Session newSession = sf.openSession();
		Transaction newTransaction = newSession.beginTransaction();
		
		Country country1 = new Country("Poland", 40000);
		newSession.save(country1);
		Category category1 = new Category("Milk", 10);
		newSession.save(category1);
		Set<Survey> surveys = new HashSet<Survey>();
		Coffee coffee1 = new Coffee("Latte", country1, category1, surveys);
		newSession.save(coffee1);
		Customer customer1 = new Customer("Zbyszek", country1, surveys);
		newSession.save(customer1);
		Survey survey1 = new Survey(customer1, coffee1, 7);
		Survey survey2 = new Survey(customer1, coffee1, 8);
		Survey survey3 = new Survey(customer1, coffee1, 9);
		surveys.add(survey1);
		surveys.add(survey2);
		surveys.add(survey3);
		
		//List list = newSession.createQuery("select count(distinct s.coffee.id) from Customer c join c.surveys s where s.stars <= 8").list();
		List list = newSession.createQuery("from Customer").list();
		Customer cust1 = (Customer) list.get(0);
		
		//List list1 = newSession.createCriteria(Survey.class)
		//		.add(Restrictions.eq("stars", new Integer(8)))
		//		.list();
		//System.out.println(list1);
		
		newTransaction.commit();
		newSession.close();

		
		
		String name = request.getParameter("name");
		String welcomeMessage = "Welcome " + name + ". Number of coffee names rated <= 8: ";
		out.println("<h1>"+welcomeMessage+"</h1>");

		out.println("</body>");
		out.println("</html>");
		//out.close();
		
		request.setAttribute("customer", cust1);
		RequestDispatcher rd = request.getRequestDispatcher("aaa.jsp");
		rd.forward(request, response);
	}

	public void destroy() {

	}
} 