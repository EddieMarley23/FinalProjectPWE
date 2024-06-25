package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class SysAdminDaoJDBC {
	
	private Connection conn;
	PreparedStatement st = null;
	ResultSet rs = null;

	public SysAdminDaoJDBC() {
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
	
public SysAdmin authenticateLogin(SysAdmin admin) throws SQLException, ClassNotFoundException {
		
		

		st = conn.prepareStatement("SELECT * FROM sys_admin WHERE name = ? AND password = ?");
		
																							
		st.setString(1, admin.getName());
		st.setString(2, admin.getPassword());

		rs = st.executeQuery();

		// Verifica se há registro de usuário
		if (rs.next()) {
			String name = rs.getString("Name"); 
			
			String password = rs.getString("password");
		
			 SysAdmin authenticatedUser = new SysAdmin(name, password);
			
			
			
			return authenticatedUser;
		} else {
			System.out.println("Nenhum usuário encontrado");
			return null; 
		}

	}
	
	
	


}
