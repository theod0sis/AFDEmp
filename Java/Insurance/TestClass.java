import java.util.*;

public class TestClass {
	
	static Insurance insurance1=new Life(0,10,20);
	static Insurance insurance2=new Life(1,10,20); 
	static Insurance insurance3=new Life(2,10,20); 
	static Insurance insurance4=new Life(3,10,20); 
	static Insurance insurance5=new Life(4,10,20); 
	static Insurance insurance6=new Health(5,20); 
	static Insurance insurance7=new Health(6,20);
	static Insurance insurance8=new Health(7,20);
	static Insurance insurance9=new Health(8,20);
	static Insurance insurance10=new Health(9,20);
	static Insurance[] insurances={insurance1,insurance2,insurance3,insurance4,insurance5,insurance6,insurance7,insurance8,insurance9,insurance10};
	
	public static void main (String[] args){
		Customer customer1 = new Customer("Maria Papadopoulou", 1988, "female");
		Customer customer2 = new Customer("Kakomoiris Kakomoiroglou", 1983, "male");
		Customer customer3 = new Customer("Albert Einstein", 1950, "male");
		Customer customer4 = new Customer("Alan Turing", 1940, "male");
		Customer customer5 = new Customer("Mata Hari", 1932, "female");
		Customer customer6 = new Customer("Margarita Margaro", 1962, "female");
		Customer customer7 = new Customer("Theodosis Theodosiou", 1992, "male");
		Customer customer8 = new Customer("Epameinondas Rowe", 1976, "male");
		Customer customer9 = new Customer("Pelopidas Ananas", 1987, "male");
		Customer customer10 = new Customer("Aloe Antoniou", 1989, "female");
		
		Customer[] customers = {customer1,customer2,customer3,customer4,customer5,customer6,customer7,customer8,customer9,customer10};
		
		Scanner keyboard = new Scanner(System.in);
		int x;
		do{
			System.out.println( "*****    Menu     ***** ");
			System.out.println("1. Print all Insurances  ");
			System.out.println("2. Search  insurances by customer code");
			System.out.println("3. Search  insurances by insurance code");
			x = keyboard.nextInt();
		
			if ( x== 1 ) {
				for ( int i=0; i<insurances.length;i++){
				insurances[i].print(insurances[i]);
				}
			}
			else if (x==2){
				System.out.println("give me the Customer code");
				int k=keyboard.nextInt();
				for (int i=0; i<insurances.length;i++){
					if (insurances[i].getCustomer_code()==k){
						System.out.println(insurances[i].toString());
					}
				}
			}
			else if(x==3){
				System.out.println("give me the Insurance code");
				int k=keyboard.nextInt();
				for (int i=0; i<insurances.length;i++){
					if (insurances[i].getInsurance_code()== k){
						System.out.println(insurances[i].toString());
					}
				}
			}
		}while( x!=0) ;
		
	}
	
}
