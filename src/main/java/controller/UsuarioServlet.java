package controller;

import java.io.IOException;
import java.sql.SQLException;

import entities.SysAdmin;
import entities.SysAdminDaoJDBC;
import entities.User;
import entities.UserDaoJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {

		String action = request.getParameter("action");
		UserDaoJDBC userDao = new UserDaoJDBC();

		if (action != null && action.equals("directToUser")) {

			request.getRequestDispatcher("WEB-INF/View/RegisterUser.jsp").forward(request, response);

		} else if (action != null && action.equals("directToAdmin")) {
			System.out.println("Fui até aqui");

			request.getRequestDispatcher("WEB-INF/View/LoginADM.jsp").forward(request, response);

		} else if (action != null && action.equals("loginAdmin")) {

			SysAdmin verifiedSys = AuthenticateLoginAdmin(request);

			if (verifiedSys != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", verifiedSys.getName());
				response.sendRedirect("/Final_ProjectPWE/ShowMovies");
			} else {
				request.setAttribute("errorMessage", "Login falhou. Email ou senha inválidos.");
				request.getRequestDispatcher("WEB-INF/View/LoginADM.jsp").forward(request, response);
			}

		} else if (action != null && action.equals("login")) {

			User verifiedUser = AuthenticateLogin(request, userDao);

			if (verifiedUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", verifiedUser.getName());
				response.sendRedirect("/Final_ProjectPWE/ShowMovies");
			} else {
				request.setAttribute("errorMessage", "Login falhou. Email ou senha inválidos.");
				response.sendRedirect("index.jsp");
			}
		} else {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User(name, email, password);

			try {
				userDao.InsertData(user);
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			response.sendRedirect("index.jsp");

		}

	}

	private User AuthenticateLogin(HttpServletRequest request, UserDaoJDBC userDao) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(name, email, password);
		User verifiedUser = null;

		try {

			verifiedUser = userDao.authenticateLogin(user);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return verifiedUser;
	}

	private SysAdmin AuthenticateLoginAdmin(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		SysAdmin sysadmin = new SysAdmin(name, password);
		SysAdminDaoJDBC sysDao = new SysAdminDaoJDBC();
		SysAdmin verifiedSys = null;

		try {
			verifiedSys = sysDao.authenticateLogin(sysadmin);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return verifiedSys;
	}
}
