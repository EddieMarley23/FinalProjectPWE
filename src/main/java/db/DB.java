package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

  private static final String URL = "jdbc:mysql://localhost:3306/finalprojectpwe";  // Replace with your actual database URL
  private static final String USERNAME = "developer";  // Replace with your database username
  private static final String PASSWORD = "Msce1425";  // Replace with your database password
  private static Connection conn = null;

  public static Connection getConnection() throws SQLException, ClassNotFoundException { // Throws SQLException
	    if (conn == null) {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	    }
	    return conn;
  }
  
  public static void closeConnection() throws SQLException { // Throws SQLException
	    if (conn != null) {
	      conn.close();
	      // conn = null; // Optional line for clarity
	    }
	  }

  public static void closeStatement(Statement st) throws SQLException { // Existing method with minor change
    if (st != null) {
      st.close();
    }
  }

  public static void closeResultSet(ResultSet rs) throws SQLException { // Existing method with minor change
    if (rs != null) {
      rs.close();
    }
  }
}