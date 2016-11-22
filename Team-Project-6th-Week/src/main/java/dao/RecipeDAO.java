package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;


import domain.Recipe;


public class RecipeDAO {

	public ArrayList<Recipe> findByIng(String[] ingredients) throws Exception {	
		try{
			boolean emptyQuery=true;
		String sqlquery;
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		sqlquery = "select  john.* ,count(favorite.iduser) as count FROM (select distinct recipe.* from recipe inner join rec_ing on recipe.idrecipe=rec_ing.idrecipe inner join ingredient"+ " on rec_ing.idingredient=ingredient.idingredient where ((ingredient.name like ?)or (recipe.desc_ing like ?))";

		
		for(int i=1; i<ingredients.length;i++){
			
			if(ingredients[i-1].matches("^$|\\s+,+")){i++;
			}else{
				
			sqlquery += "and ((ingredient.name like ?)or (recipe.desc_ing like ?))";}

		}
		
		sqlquery += ")as john left join favorite on john.idrecipe=favorite.idrecipe group by(john.idrecipe) order by(count) desc ";
		Connection con=Database.open();
		
		PreparedStatement stmt = con.prepareStatement(sqlquery);
		
		int k=1;
		for(int i=1; i<=ingredients.length;i++){
	
			if(ingredients[i-1].matches("^$|^\\s+,+")){i++;
			}else{
				emptyQuery=false;
			stmt.setString(k, "%"+ingredients[i-1]+"%");
			k++;
			stmt.setString(k, "% "+ingredients[i-1]+"%");
			k++;
			
			}
		}
      
		
		if(emptyQuery){
			return list;
		}
		else{
		ResultSet rs = stmt.executeQuery();
		Recipe recipe =null;

		while(rs.next()){
		    recipe =new Recipe();
			recipe.setId(rs.getInt("idrecipe"));
			recipe.setName(rs.getString("name"));
			recipe.setCalories(rs.getString("calories"));
			recipe.setDuration(rs.getString("duration"));
			recipe.setDescription(rs.getString("description"));
			
			recipe.setCategoryID(rs.getInt("idcategory"));
			recipe.setIngredientText(rs.getString("desc_ing"));
			recipe.setImg(rs.getString("image"));
			recipe.setFavs(rs.getInt("count"));
		    list.add(recipe);
		}
		stmt.close();
		con.close();
		rs.close();
		return list;}
	}catch(Exception e){
		throw new Exception("An error occured while searching for recipies by ingridient in database: " + e.getMessage());
	}	

	}

	public ArrayList<Recipe> findByCat(int categoryId) throws Exception {
		try{
		String sqlquery;
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		sqlquery = "select  john.* ,count(favorite.iduser) as count FROM (select DISTINCT   recipe.* from recipe where  idcategory=?)"+
		"as john left join favorite on john.idrecipe=favorite.idrecipe group by(john.idrecipe) order by(count) desc";
		Connection con=Database.open();
		PreparedStatement stmt = con.prepareStatement(sqlquery);
		stmt.setInt(1, categoryId);
		ResultSet rs = stmt.executeQuery();
		Recipe recipe =null;
		while(rs.next()){
		    recipe =new Recipe();
			recipe.setId(rs.getInt("idrecipe"));
			recipe.setName(rs.getString("name"));
			recipe.setCalories(rs.getString("calories"));
			recipe.setDuration(rs.getString("duration"));
			recipe.setDescription(rs.getString("description"));
			recipe.setCategoryID(rs.getInt("idcategory"));
			recipe.setIngredientText(rs.getString("desc_ing"));
			recipe.setImg(rs.getString("image"));
			recipe.setFavs(rs.getInt("count"));
		    list.add(recipe);
		}
		stmt.close();
		con.close();
		rs.close();
		return list;
	
	
}catch(Exception e){
	throw new Exception("An error occured while searching for recipies by category in database: " + e.getMessage());
}	



	}
	
	public Recipe findById(int recipeId) throws Exception {
		
		try{
			String sqlquery;
			sqlquery = "select  john.* ,count(favorite.iduser) as count FROM (select * from youcook.recipe where youcook.recipe.idrecipe = ?)as john left join favorite on john.idrecipe=favorite.idrecipe group by(john.idrecipe) order by(count) desc";
			Connection con=Database.open();
			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, recipeId);
			ResultSet rs = stmt.executeQuery();
			Recipe recipe =null;
			if (rs.next()){
			    recipe =new Recipe();
				recipe.setId(rs.getInt("idrecipe"));
				recipe.setName(rs.getString("name"));
				recipe.setCalories(rs.getString("calories"));
				recipe.setDuration(rs.getString("duration"));
				recipe.setDescription(rs.getString("description"));
				recipe.setCategoryID(rs.getInt("idcategory"));
				recipe.setIngredientText(rs.getString("desc_ing"));
				recipe.setImg(rs.getString("image"));
				recipe.setFavs(rs.getInt("count"));
			}
			stmt.close();
			con.close();
			rs.close();
			return recipe;
		
		
	}catch(Exception e){
		throw new Exception("An error occured while searching for recipe in database: " + e.getMessage());
	}	

		
	}
}


