import java.util.*;


public class askisi5{
  public static char[][] pinakas= new char [3][3];

  public static void main(String[] args){
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        pinakas[i][j]=' ';
      }
    }
    int turn = 1;
    do{
      if ((turn % 2)==0){
        turn('X');
        drawFunction(pinakas);
        turn = turn + 1;
      }
      else {
        turn('O');
        drawFunction(pinakas);
        turn = turn + 1;
      }
    }while( !(check()) );
  }

  public static void turn(char k){
    boolean flag = false;
    Scanner keyboard = new Scanner(System.in);
    do  {
        System.out.println("Enter the position x of your sympol ");
        int x = keyboard.nextInt();
        System.out.println("Enter the position y of your sympol ");
        int y = keyboard.nextInt();
        if ( x <3 && x>=0 && y <3 && y>=0 ){
            if ( pinakas[x][y] == ' '){
              pinakas[x][y]=k;
              flag=true;
              System.out.println(!flag);
            }
        }
    }while( !flag );
  }


  public static void drawFunction(char[][] pinakas){
    for (int i=0; i<3;i++){
        System.out.println(pinakas[i][0]+ " |" + pinakas[i][1] + " |" + pinakas[i][2]);
    }
  }
  public static boolean check(){
    for (int i=0;i<3;i++){
      if (pinakas[i][0]=='X' && pinakas[i][1]=='X' && pinakas[i][2]=='X'){
        return true;
      }
      else if (pinakas[i][0]=='O' && pinakas[i][1]=='O' && pinakas[i][2]=='O') {
        return true;
      }
      else if (pinakas[0][i]=='X' && pinakas[1][i]=='X' && pinakas[2][i]=='X') {
        return true;
      }
      else if (pinakas[0][i]=='O' && pinakas[1][i]=='O' && pinakas[2][i]=='O') {
        return true;
      }
    }
    if (pinakas[0][0]=='X' && pinakas[1][1]=='X' && pinakas[2][2]=='X'){
      return true;
    }
    else if (pinakas[0][0]=='O' && pinakas[1][1]=='O' && pinakas[2][2]=='O') {
      return true;
    }
    else if (pinakas[0][2]=='O' && pinakas[1][1]=='O' && pinakas[2][0]=='O') {
      return true;
    }
    else if (pinakas[0][2]=='X' && pinakas[1][1]=='X' && pinakas[2][0]=='X') {
      return true;
    }
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        if (pinakas[i][j]==' '){
          return false;
        }
      }
    }
    return true;
  }



}
