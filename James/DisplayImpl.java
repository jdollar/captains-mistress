import java.util.Scanner;

public class  DisplayImpl implements Display{
  public void ReDrawGameBoard(int[] log, int[][] gameboard){
  }
  public void DrawMenu(){
    int userInput = 0;
    Scanner input = new Scanner (System.in);

    while (userInput != 1 || 3){
      System.out.println("");
      System.out.println("Main Menu");
      System.out.println("");
      System.out.println("1)Play");
      System.out.println("2)Instructions");
      System.out.println("3)Quit Game");
      
      switch(userInput){
        case 1:  GameEngine();
                 break;
        case 2:  ;
                 break;
        case 3:  System.exit(0);
                 break;
        default: System.out.println("Invalid Data, please try again");
                 break;
    }



  }
  public static void main(String[] args){
  	DisplayImpl link = new DisplayImpl();
  	link.DrawMenu();
  }
}
