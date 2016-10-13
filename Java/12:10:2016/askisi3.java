import java.util.*;

   public class askisi3 {

     public static void main(String[] args) {

       int[] list=new int[]{1,2,3,4,5,6,7,8,9,10};
       Scanner reader = new Scanner(System.in);  // Reading from System.in
       System.out.println("Enter a number of shifts: ");
       int n1 = reader.nextInt();
       System.out.println (Arrays.toString(Shift(list,n1)));

     }
       public static int[] Shift(int[] x,int n){
         int[] k =new int[10];
         for (int j=0; j<=n; j++){
           for (int i=0; i<x.length; i++){
             if (i+1>=10){
               k[i+1-10]=x[i];
           }
            else{
              k[i+1]=x[i];
           }
          }
          for (int i=0;i<x.length;i++){
            x[i]=k[i];
          }
        //  System.out.println (Arrays.toString(k));
        }
         return k;
       }

     }
