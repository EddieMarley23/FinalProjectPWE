package entities;

import java.sql.SQLException;

public interface UserDao {
	
	public void InsertData(User user) throws SQLException;
	public User authenticateLogin(User user) throws SQLException, ClassNotFoundException;
	

}
