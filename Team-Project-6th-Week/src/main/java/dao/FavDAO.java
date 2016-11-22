package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Recipe;

public class FavDAO {

	
	public ArrayList<Recipe> findFav (int userId)  {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try{
			
			String sqlquery;
			sqlquery = "select  john.* ,count(favorite.iduser) as count FROM (select recipe.* from recipe inner join favorite on favorite.idrecipe=recipe.idrecipe  where  favorite.iduser=?) as john inner join favorite on john.idrecipe=favorite.idrecipe group by(favorite.idrecipe) order by(count) desc" ;
			Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
		
			Recipe recipe;
			while (rs.next()){
				recipe =new Recipe();
				recipe.setId(rs.getInt("idrecipe"));
				recipe.setName(rs.getString("name"));
				recipe.setCalories(rs.getString("calories"));
				recipe.setDuration(rs.getString("duration"));
				recipe.setCategoryID(rs.getInt("idcategory"));
				recipe.setIngredientText(rs.getString("desc_ing"));
				recipe.setImg(rs.getString("image"));
				recipe.setFavs(rs.getInt("count"));
				recipes.add(recipe);
				
			}
			stmt.close();
			con.close();
			rs.close();
		}catch(Exception e){
		
			System.out.println("An error occured while find all  favorites in database for a user: " + e.getMessage());
		}
		return recipes;
	}

	public void makeFav(int userId, int recipeId) {
		try{
			String sqlquery;
			sqlquery = "insert into favorite values (?,?); " ;
			Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, userId);	
			stmt.setInt(2, recipeId);
			stmt.executeUpdate();
			stmt.close();
			con.close(); 
		}catch(Exception e){
			System.out.println("An error occured while inserting favorite in database: " + e.getMessage());
		}

	}
	public void deleteFav(int userId, int recipeId) {
		try{
			String sqlquery;
			sqlquery = "DELETE FROM favorite WHERE favorite.idrecipe=? and favorite.iduser=?;" ;
			Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, recipeId);	
			stmt.setInt(2, userId);
			stmt.executeUpdate();
			stmt.close();
			con.close(); 
		}catch(Exception e){
			System.out.println("An error occured while deleting favorite in database: " + e.getMessage());
		}

	}

	public boolean isFav(int userId,int recipeId){
		try{
		String sqlquery;
		sqlquery = "select * from favorite where iduser=? and idrecipe=? ;" ;
		Connection con=Database.open();
		PreparedStatement stmt = con.prepareStatement(sqlquery);
		stmt.setInt(1, userId);
		stmt.setInt(2, recipeId);
		ResultSet rs = stmt.executeQuery();
		int counter = 0;
		while (rs.next()){
			counter += 1;
		}
		stmt.close();
		con.close();
		rs.close();
		if (counter==0){
			return false;
		}else{
			return true;
		}
	}catch(Exception e){
		System.out.println("An error occured while finding favorite in database: " + e.getMessage());
	}
		
		return false;

	}
}
