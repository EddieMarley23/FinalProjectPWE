package controller;

import java.io.IOException;
import java.sql.SQLException;

import entities.User;
import entities.UserDaoJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action"); 
		UserDaoJDBC userDao = new UserDaoJDBC();
		
		
		
		if (action != null && action.equals("login")) {
		
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User(name, email, password);
			
			
			
			try {
				
				userDao.authenticateLogin(user);
				
	           
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			if (user != null) {
				
                HttpSession session = request.getSession();
				session.setAttribute("userName", user.getName());
				
			
				response.sendRedirect("/Final_ProjectPWE/ShowMovies");
			} else
			
				request.setAttribute("errorMessage", "Login falhou. Email ou senha inválidos.");
		} else {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User(name, email, password);
			
			
			try {
				userDao.InsertData(user);
				response.sendRedirect("Login.jsp");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}

		

	}
}
