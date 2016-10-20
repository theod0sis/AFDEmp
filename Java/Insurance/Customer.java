
public class Customer {
	
	private String name;
	private int year;
	private String sex;
	private static int code;
	
	Customer(String name , int year,String sex){
		code+=1;
		this.name=name;
		this.year=year;
		this.sex=sex;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getCode(){
		return this.code;
	}
	public String getName(){
		return this.name;
	}
	public void setYear(int year){
		this.year=year;
	}
	public int getYear(){
		return this.year;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return this.sex;
	}
	
	public String toString(){
		return (this.name + " "+ this.sex + " "+ this.year + " " + this.code );
	}
	
}
