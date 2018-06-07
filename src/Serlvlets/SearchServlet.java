package Serlvlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zad1.SQLSelect;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if("tytul".equals(request.getParameter("opcja"))) {
			SQLSelect sel = new SQLSelect();
			request.setAttribute("bookList", sel.selectTytul(request.getParameter("opcjeWyszukiwania")));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("autor".equals(request.getParameter("opcja"))) {
			SQLSelect sel = new SQLSelect();
			request.setAttribute("bookList", sel.selectAutor(request.getParameter("opcjeWyszukiwania")));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);	
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
