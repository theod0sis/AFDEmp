import java.util.*;

public class Quotient {
	
	public static double calcQuotient(int numerator, int denominator) throws ArithmeticException{
		return numerator/denominator;
	}
	
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		boolean flag;
	do {
		 flag=false;
		try{
	
			int num=reader.nextInt();
			int den=reader.nextInt();
			System.out.println(calcQuotient(num,den));
		}catch(ArithmeticException x){
			System.out.println("edwses 0");
			flag=true;
		}catch(InputMismatchException x){
			System.out.println("dn einai arithmos");
			reader.nextLine();
			flag=true;
		}
		}while ( flag==true);
	}
}
