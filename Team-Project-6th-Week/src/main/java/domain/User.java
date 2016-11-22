package domain;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String mail;
	private int admin=0;

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
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public User(String name, String mail,String password){
		setName(name);
		setMail(mail);
		setPassword(password);
	}
	
	
	public User(String name, String mail,String password,int id, int Admin){
		setId(id);
		setName(name);
		setMail(mail);
		setPassword(password);
		setAdmin(Admin);
		
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
}
