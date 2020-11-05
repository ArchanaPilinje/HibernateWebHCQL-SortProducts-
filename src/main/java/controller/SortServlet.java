package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.Product;

import dao.ProductDAOImpl;


public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ProductDAOImpl impl=new ProductDAOImpl();
		String order=request.getParameter("sort");
//		List<Product> prod=impl.sortByCostPrice(order);
	if(order.equals("asc")) {
			request.setAttribute("sort","asc");
			request.getRequestDispatcher("sortCP.jsp").forward(request, response);
		}
		else {
			request.setAttribute("sort","desc");
			request.getRequestDispatcher("sortCP.jsp").forward(request, response);
		}
		
	}

}
