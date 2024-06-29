package entities;

import java.sql.SQLException;

public interface SysAdminDao {

	public SysAdmin authenticateLogin(SysAdmin admin) throws SQLException, ClassNotFoundException;
}
