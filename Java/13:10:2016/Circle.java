import java.lang.*;
import java.util.*;

  public class Circle{

    public static void main(String[] args){

   }
      static int  cop;
      private int x;
      private int y;
      private int r;
      static final Double p=3.14;
      //constructor
      Circle(){
        cop+=1;
        this.x=0;
        this.y=0;
        this.r=0;
      }
      Circle(int x, int y){
        this.y=x;
        cop+=1;
        this.x=y;
      }
      Circle(int x, int y, int r){
        this.x=x;
        cop+=1;
        this.y=y;
        this.r=r;
      }

      public void Print(){
        System.out.println (" I'm a circle at point (" + this.x + "," + this.y + ") with radius " + this.r);
      }
  //pairnw to x
      public int getX (){
        return x;
      }
  //dinw timh sthn x
      public void setX(int x){
        this.x=x;
      }
      //pairnw to y
      public int getY (){
            return y;
          }
      //dinw timh sthn Y
      public void setY(int y){
            this.y=y;
          }
      //pairnw to r
          public int getR (){
              return x;
                          }
      //dinw timh sthn r
          public void setR(int r){
            this.r=r;
          }

          public Double calculateArea(int r){
            return(this.p*r*r);
          }

          public Double calculatePerimeter(int r){
            return(2*this.p*r);
          }

          public Circle copy() {
            Circle new_circle = new Circle();
              new_circle.x = this.x;
              new_circle.y = this.y;
              new_circle.r = this.r;
              return new_circle;
            }

          public boolean cocentric(Circle x, Circle y){
            return((x.x==y.x) && (y.y==x.y)) ;

          }
      }
