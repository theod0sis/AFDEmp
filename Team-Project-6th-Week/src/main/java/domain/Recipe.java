package domain;

public class Recipe {

	private int id;
	private String name;
	private String calories;
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", calories=" + calories + ", duration=" + duration
				+ ", description=" + description + ", categoryId=" + categoryId + ", ingredientText=" + ingredientText
				+ ", img=" + img + ", favs=" + favs + "]";
	}

	private String duration;
	private String description;
	private int categoryId;
	private String ingredientText;
	private String img;
	private int favs;
	
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setCalories(String calories){
		this.calories = calories;
	}
	
	public String getCalories(){
		return this.calories;
	}
	
	public void setDuration(String duration){
		this.duration = duration;
	}
	
	public String getDuration(){
		return this.duration;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setCategoryID(int categoryID){
		this.categoryId = categoryID;
	}
	
	public int getCategoryID(){
		return this.categoryId;
	}
	
	public void setIngredientText(String ingredientText){
		this.ingredientText = ingredientText;
	}
	
	public String getIngredientText(){
		return this.ingredientText;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getFavs() {
		return favs;
	}

	public void setFavs(int favs) {
		this.favs = favs;
	}

}
