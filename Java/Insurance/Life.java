
public class Life extends Insurance {
	 private int amount;
	 
	Life(int customer_code, int duration, int amount ){
		super(customer_code,duration);
		this.amount=amount;
	}
	
	public void setAmount(int amount){
		this.amount=amount;
	}
	public int getAmount(){
		return amount;
	}
	
	public int insurance_cost(){
		return 100 + (5 * duration);
	}
	public String toString(){
		return (amount + " " + customer_code + " " + insurance_code +  " "+  duration);
	}
	
}
