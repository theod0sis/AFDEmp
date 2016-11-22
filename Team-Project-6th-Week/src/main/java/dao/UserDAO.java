package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.User;



public class UserDAO  {
	
	
	public User find(String mail) throws Exception{
		
		try{	
			User user;
			
			String sqlquery;
			sqlquery = "SELECT * FROM youcook.user"
					+ " where email=?;";
			 Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
		     stmt.setString(1, mail);	
		  
		
		ResultSet rs = stmt.executeQuery();
		
		
		if(rs.next()){
			user= new User(rs.getString("name"), rs.getString("email"), rs.getString("password"),rs.getInt("iduser"),rs.getInt("isadmin"));
			rs.close();
			stmt.close();
			con.close();
			return user;
		}
		else{
			rs.close();stmt.close();con.close();
		return null;
		}
		}catch(Exception e){
			throw new Exception("An error occured while searching for user in database: " + e.getMessage());
			}	
		
	}
	
	public boolean register(User user) throws Exception {
		try{
			if(find(user.getMail())==null){
			String sqlquery;
			sqlquery = "insert into youcook.user(name,email,password,isadmin) values (?,?,?,?);";
			 Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
		     stmt.setString(1, EscapeHtml.escape(user.getName()));	
		     stmt.setString(2, EscapeHtml.escape(user.getMail()));	
		     stmt.setString(3, user.getPassword());	
		     stmt.setInt(4, user.getAdmin());
		     stmt.executeUpdate();
		    
				stmt.close();
				con.close(); 
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw new Exception("An error occured while searching for user in database: " + e.getMessage());
		}	

	}

}