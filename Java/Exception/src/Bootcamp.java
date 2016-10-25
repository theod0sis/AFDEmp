
public class Bootcamp {

	
	public static void welcome(double theo) throws DigitException,AnotherDigitException{
		
		if (theo>25){
			throw new DigitException();}
		else{
			throw new AnotherDigitException();
		}
			
		
	}
	
	
	public static int bye(){
		try{
			welcome(299.7);
			return 0;
			
		}catch(DigitException e){
			return 605;
		}
		catch(AnotherDigitException e){
			return 230;
			
		} 
	}
}
