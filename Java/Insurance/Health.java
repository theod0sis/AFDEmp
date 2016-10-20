
public class Health extends Insurance {
	
	
	
	Health(int customer_code, int duration){
		super(customer_code,duration);
	}
	
	public String toString(){
		return (" " + customer_code + " " + insurance_code +  " "+  duration);
	}
	
	public int insurance_cost(String sex){
		if (sex=="female"){
		return (100 + (7*duration));
		}
		else {return((100 + (7*duration)+50));}
	}
}
