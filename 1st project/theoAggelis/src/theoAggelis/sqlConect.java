package theoAggelis;

import java.sql.*;


public class sqlConect {
	
	private String errorMessages = "";

	private Connection con = null;

	private PreparedStatement stmt = null;

	private ResultSet rs = null;
	
	private final String registerQuery = "insert into theoaggelis.Users (Email,Password) values (?,?);";
	private final String loginQuery = "select Users.Email, Users.Password from theoaggelis.Users where Users.Email=? and Users.Password=? ;";
	private final String commentQuery = "insert into theoaggelis.Contact (Name,Email,Comment) values (?,?,?);";
	private final String emailExist = "select Users.Email from theoaggelis.Users where Users.Email=?;";
	
	public void open() throws SQLException {
	    try {

	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception e1) {
	      errorMessages = "MySQL Driver error: <br>" + e1.getMessage();
	      throw new SQLException(errorMessages);
	    }

	    try {
	      con = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306",
	          "root", "2271042453");
	    } catch (Exception e2) {
	      errorMessages = "Could not establish connection with the Database Server: <br>"
	          + e2.getMessage();
	      con = null;
	      throw new SQLException(errorMessages);
	    }

	  }
	
	public void close() throws SQLException {
	    try {

	      if (stmt != null)
	        stmt.close();


	      if (rs != null)
	        rs.close();

	      if (con != null)
	        con.close();

	    } catch (Exception e3) {
	      errorMessages = "Could not close connection with the Database Server: <br>"
	          + e3.getMessage();
	      throw new SQLException(errorMessages);
	    }
	  }
	

	
	public String getErrorMessages() {
	    return errorMessages;
	  }
	
	
	public void register(String email, String password) throws SQLException {

	    if (con == null) {
	      errorMessages = "You must establish a connection first!";
	      throw new SQLException(errorMessages);
	    }

	    try {
	      stmt = con.prepareStatement(registerQuery);
	      // replacing the first ? with email, the second ? with password
	      stmt.setString(1, email);
	      stmt.setString(2, password);
	      // execute query
	      stmt.executeUpdate();
	      stmt.close();

	    } catch (Exception e4) {
	      errorMessages = "Error while inserting to the database: <br>"
	          + e4.getMessage();
	      throw new SQLException(errorMessages);
	    }
	  }
	
	public boolean findUser(String email, String password)throws SQLException{
		if (con == null) {
		      errorMessages = "You must establish a connection first!";
		      throw new SQLException(errorMessages);
		    }
		
		try {
		      stmt = con.prepareStatement(loginQuery);
		      // replacing the first ? with email, the second ? with password
		      stmt.setString(1, email);
		      stmt.setString(2, password);
		      // execute query
		      rs = stmt.executeQuery();
		      
		      if (rs.next()){
		    	  return true;
		      }
		      stmt.close();
		      
		      return false;

		    } catch (Exception e4) {
		      errorMessages = "Error while  to the database: <br>"
		          + e4.getMessage();
		      throw new SQLException(errorMessages);
		    }
		
		
	}
	
	
	public void commentIns(String email, String name,String comment) throws SQLException {

	    if (con == null) {
	      errorMessages = "You must establish a connection first!";
	      throw new SQLException(errorMessages);
	    }

	    try {
	      stmt = con.prepareStatement(commentQuery);
	      // replacing the first ? with email, the second ? with password
	      stmt.setString(1, name);
	      stmt.setString(2, email);
	      stmt.setString(3, comment);
	      // execute query
	      stmt.executeUpdate();
	      stmt.close();

	    } catch (Exception e4) {
	      errorMessages = "Error while inserting to the database: <br>"
	          + e4.getMessage();
	      throw new SQLException(errorMessages);
	    }
	  }
	
	public boolean emailExist(String email) {

	    if (con == null) {
	      errorMessages = "You must establish a connection first!";
	      return false;
	    }

	    try {
	      stmt = con.prepareStatement(emailExist);
	      // replacing the first ? with userName and the second ? with
	      // userPassword
	      stmt.setString(1, email);
	      // execute query
	      rs = stmt.executeQuery();

	      int counter = 0;

	      if (rs.next()){
	        counter++;
	      }
	      if (counter == 1) {
	        stmt.close();
	        rs.close();
	        return true;
	      } else {
	        //errorMessages = "Error Login: <br>Invalide username or password!";
	        stmt.close();
	        rs.close();
	        return false;
	      }
	    } catch (Exception e4) {
	      errorMessages = "Error while executing authentication query: <br>"
	          + e4.getMessage();
	      return false;
	    }
	  }

	
	
	
}
