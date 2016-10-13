import java.util.*;

   public class askisi1 {

       static public int bootCamp(int num1, int num2){

          if (num1<num2) {
            return (int)(Math.sqrt((Math.abs(num1-num2))));
          }
          else{
            return(num1+num2);
          }

        }
       public static void main(String[] args) {

         Scanner reader = new Scanner(System.in);  // Reading from System.in
         System.out.println("Enter a number: ");
         int n1 = reader.nextInt();
         System.out.println("Enter a number2: ");
         int n2= reader.nextInt();
         System.out.println(bootCamp(n1,n2));
       }
       
   }
