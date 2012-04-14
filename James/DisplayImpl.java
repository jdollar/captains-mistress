package James;
import java.util.*;
import Zach.*;

public class DisplayImpl implements Display{
  public static void main(String[] args){
    DisplayImpl link = new DisplayImpl();
    link.DrawMenu();
  }
  public void ReDrawGameBoard(int[] log, int[][] gameboard){
  }
  public void DrawMenu(){
    int menuInput = 0;
    Scanner input = new Scanner (System.in);

    while (menuInput != 1 && menuInput != 3){
      System.out.println("");
      System.out.println("Main Menu");
      System.out.println("");
      System.out.println("1)Play");
      System.out.println("2)Instructions");
      System.out.println("3)Quit Game");
      System.out.println("");

      try {
        menuInput = input.nextInt();
      }
      catch (InputMismatchException e) {
        System.out.println(input.next() + "!");
      }

      switch(menuInput){
        case 1:  System.out.println("");
                 System.out.println("Number of Players");
                 System.out.println("");
                 System.out.println("0)Computer vs. Computer");
                 System.out.println("1)Player vs. Computer");
                 System.out.println("2)Player vs. Player");
                 System.out.println("");
                 break;
        case 2:  System.out.println("");
                 System.out.println("The goal is to get four in a row.");
                 break;
        case 3:  System.exit(0);
                 break;
        default: System.out.println("");
                 System.out.println("Invalid Data, please try again");
                 break;
      }
    }
  }
}
