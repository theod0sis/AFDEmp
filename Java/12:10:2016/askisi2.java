import java.util.*;

   public class askisi2 {

      public static class Dice{

        public static int rolls=0;

        public void Roll(){
          int n= (int) Math.random()*6+1;
          int n1= (int) Math.random()*6+1;
          if ((n==n1) && (n==1)){
            System.out.println(rolls);
          }
          else{
          rolls+=rolls;
          Roll();
        }
        }
      }

      public static void main(String[] args) {
        Dice k = new Dice();
        k.Roll();
       }
}
