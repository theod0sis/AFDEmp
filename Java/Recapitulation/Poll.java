import java.util.*;

public class Poll {

	public static void main(String [] args) {
		
		int []	rates= {1, 2, 6, 4, 8, 5, 9, 7, 8, 10, 1, 6, 3, 8, 6, 10, 3, 8, 2, 7, 6, 5, 7, 6, 8, 6, 7, 5, 6, 6, 5, 6, 7, 5, 6, 8,
				4, 6, 8, 10};
		int [] freq={0,0,0,0,0,0,0,0,0,0};
		for ( int j=1; j<=10; j++){
			for ( int i=0; i<40; i++){
				if (j==rates[i]){
					freq[j-1] += 1; 
				}
					
			}
		}
		for ( int j=1;j<=10; j++){
			
			System.out.println( j + " " + freq[j-1]);
			
		}
		
	}

}
