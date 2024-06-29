package controller;

import java.io.IOException;

import com.mysql.cj.xdevapi.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("LogOut")) {
			
			HttpSession session = request.getSession();
			session.invalidate();



			response.sendRedirect("/Final_ProjectPWE/index.jsp");
			
		}else {
			response.sendRedirect("/Final_ProjectPWE/ShowMovies");
		}
		
		
	}

}
