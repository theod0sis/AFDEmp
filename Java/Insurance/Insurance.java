
public class Insurance {
	
	protected int customer_code;
	protected static int insurance_code;
	protected int duration;
	
	Insurance(int customer_code, int duration){
		this.customer_code=customer_code;
		this.duration=duration;
		this.insurance_code++;
	}
	
	public void setCusomer_code(int customer_code){
		this.customer_code=customer_code;
	}
	public int getCustomer_code(){
		return this.customer_code;
	}
	public int getInsurance_code(){
		return this.insurance_code;
	}
	public void setDuration(int duration){
		this.duration=duration;
	}
	public int getDuration(){
		return this.duration ;
	}
	
	public String toString(){
		return (customer_code + "  " + insurance_code + "  "+ duration);
	}
	public int insurance_cost(){
		return 100;
	}
	
	public void print(Insurance insurance){
		System.out.println(insurance.toString());
		}
	
	public void print2(int insurance_code,Insurance[] insurance){
		for (int i=0; i<insurance.length;i++){
			if (insurance[i].insurance_code == insurance_code){
				System.out.println(insurance[i].toString());
			}
		}
	}
	
	
}
