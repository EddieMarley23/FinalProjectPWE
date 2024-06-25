package controller;

import java.io.IOException;
import java.sql.SQLException;

import entities.SysAdmin;
import entities.SysAdminDaoJDBC;
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
			throws ServletException, IOException, NullPointerException {

		String action = request.getParameter("action");
		UserDaoJDBC userDao = new UserDaoJDBC();

		if (action != null && action.equals("directToAdmin")) {
			
			response.sendRedirect("LoginADM.jsp");
			

		} else if (action != null && action.equals("loginAdmin")) {

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

			if (verifiedSys != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", verifiedSys.getName());
				response.sendRedirect("/Final_ProjectPWE/ShowMovies");
			} else {
				request.setAttribute("errorMessage", "Login falhou. Email ou senha inválidos.");
				response.sendRedirect("LoginADM.jsp");
			}

		} else if (action != null && action.equals("login")) {

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

			if (verifiedUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", verifiedUser.getName());
				response.sendRedirect("/Final_ProjectPWE/ShowMovies");
			} else {
				request.setAttribute("errorMessage", "Login falhou. Email ou senha inválidos.");
				response.sendRedirect("Login.jsp");
			}
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
