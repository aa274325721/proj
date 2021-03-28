package eHotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.customer;

@WebServlet("/GetAllCustomerServlet")
public class GetAllCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		PostgreSqlConn con = new PostgreSqlConn();
		List<customer> list=con.getAllCustomer();
		request.setAttribute("list", list);
		//request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		//return;
	}

}


