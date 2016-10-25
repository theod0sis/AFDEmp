import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class JavaAnagrams {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
		 	
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    br.close();
		//System.out.println(everything);
		
		  String[] str= everything.split("\\s+");
		  Scanner reader=new Scanner(System.in);
		  String string =reader.nextLine();
		  System.out.println();
		// System.out.println(Arrays.toString(str));
		   for (int i=0; i<str.length;i++){
			   if (isAnagram(string, str[i]) ) {
				   System.out.println( "Anagram" + string + " " +  str[i]);
					System.out.println("Anagrams");
			   }
		   } 
		//This part of code will test your execution (Don't touch this part of code)
		//Test Case 1
		System.out.println("Input Testing: anargram and margana");
		System.out.println("Expercted output: Anagrams");
		if (isAnagram("anagram", "margana") ) 
			System.out.println("Your output: Anagrams");
		else
			System.out.println("Your output: Not Anagrams");
		
		//Test Case 2
		System.out.println("\nInput Testing: anagramm and marganaa");
		System.out.println("Expercted output: Not Anagrams");
		if (isAnagram("anagramm", "marganaa") ) 
			System.out.println("Your output: Anagrams");
		else
			System.out.println("Your output: Not Anagrams");
		
		//Test Case 3
		System.out.println("\nInput Testing: Hello and hello");
		System.out.println("Expercted output: Anagrams");
		if (isAnagram("Hello", "hello") ) 
			System.out.println("Your output: Anagrams");
		else
	
			System.out.println("Your output: Not Anagrams");
	}
	
		   
	public static boolean isAnagram(String a, String b) {

		//Add your implementation here
		String[] arr = a.split("");
		String[] arr2 = b.split("");
		for (int i=0;i<arr.length; i++){
		arr[i]=arr[i].toLowerCase();
		}
		for (int i=0;i<arr2.length; i++){
			arr2[i]=arr2[i].toLowerCase();
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		if (arr.length!=arr2.length){
			return false;
		}
		for (int i=0;i<arr.length; i++){
				if (!(arr[i].equals(arr2[i]))){
					return false;
				}
		}
		return true;
		
	}
}
