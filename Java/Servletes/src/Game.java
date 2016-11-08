import java.util.*;

public class Game {
	public int roll[]=new int[2];
	public int numroll=0;
	public String result;
	
	public void play(){
		Random rand = new Random();
		numroll+=1;
		if ((numroll%2)==0){
			roll[1]=(int)rand.nextInt((6 - 1 + 1) + 1);
			if (roll[1]>roll[0]){
				result= "win";
			}else result= "lose";
		}else{
			roll[0]=(int)rand.nextInt((6 - 1 + 1) + 1);
			result= (""+roll[0]);
		}
	}
}
