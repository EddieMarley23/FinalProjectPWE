package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class UserDaoJDBC implements UserDao {

	private Connection conn;
	PreparedStatement st = null;
	ResultSet rs = null;

	public UserDaoJDBC() {
		try {
			conn = DB.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void InsertData(User user) throws SQLException {

		st = conn.prepareStatement("INSERT INTO user (name, email, password) VALUES (?, ?, ?)");
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getPassword()); // Hash da senha antes de armazenar

		int rowsAffected = st.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Dados inseridos com sucesso!" + rowsAffected);
		} else {
			System.out.println("Falha na inserção!");
		}

	}

	@Override
	public User authenticateLogin(User user) throws SQLException, ClassNotFoundException {
		
		

		st = conn.prepareStatement("SELECT * FROM User WHERE email = ? AND password = ?");
		// Substitua "Name" pelo nome
																							// correto da coluna
		st.setString(1, user.getEmail());
		st.setString(2, user.getPassword());

		rs = st.executeQuery();

		// Verifica se há registro de usuário
		if (rs.next()) {
			String name = rs.getString("Name"); 
			String userEmail = rs.getString("email");
			String userPassword = rs.getString("password");
		
			
			
			
			
			return user;
		} else {
			System.out.println("Nenhum usuário encontrado");
			return null; // Retorna null se a autenticação falhar
		}

	}

}
