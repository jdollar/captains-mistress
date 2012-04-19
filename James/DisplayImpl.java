package James;
import java.util.*;

public class DisplayImpl implements Display{
  private int row;
  private int column;
  private int menuInput;
  private int menuPlayer;

  public void ReDrawGameBoard(int[][] gameboard){
    row = gameboard.length;
    column = gameboard[0].length;

    System.out.println("");

    for (int y = 0; y < column; y++){
      System.out.print(" ");
      System.out.print(y+1);
    }
    System.out.println("");

    for (int x = 0; x < row; x++) {
      System.out.print("|");
      for (int y = 0; y < column; y++) {
        if (gameboard[x][y] == 0){
          System.out.print("_");
          System.out.print("|");
        }
        else if (gameboard[x][y] == 1){
          System.out.print("X");
          System.out.print("|");
        }
        else if (gameboard[x][y] == 2){
          System.out.print("O");
          System.out.print("|");
        }
      }
      System.out.println("");
    }
  }
  public int DrawMenu(){
    menuInput = 0;
    menuPlayer = 4;
    Scanner input = new Scanner (System.in);

    while (menuInput != 1 && menuInput != 3){
      System.out.println("");
      System.out.println("Main Menu");
      System.out.println("");
      System.out.println("1) Play");
      System.out.println("2) Instructions");
      System.out.println("3) Quit Game");
      System.out.println("");

      try {
        menuInput = input.nextInt();
      }
      catch (InputMismatchException e) {
        System.out.println("");
        System.out.println(input.next() + " is invalid data!");
      }

      switch(menuInput){
        case 1:  while (menuPlayer != 0 && menuPlayer != 1 && menuPlayer != 2 && menuPlayer != 3){
                   System.out.println("");
                   System.out.println("Number of Players");
                   System.out.println("");
                   System.out.println("0) Computer vs. Computer");
                   System.out.println("1) Player vs. Computer");
                   System.out.println("2) Player vs. Player");
                   System.out.println("3) Back");
                   System.out.println("");
  
                   try {
                     menuPlayer = input.nextInt();
                   }
                   catch (InputMismatchException e) {
                     System.out.println("");
                     System.out.println(input.next() + " is invalid data!");
                   }
                 }
                 if (menuPlayer == 3){
                     menuInput = 0;
                     menuPlayer = 4;
                   }
                 break;
        case 2:  System.out.println("");
                 System.out.println("The goal is to get four of your tokens in a row either " +
                   "horizontally, vertically, or diagonally.");
                 System.out.println("");
                 System.out.println("The game is played with two players." +
                   " Each turn, a player selects the column they wish to place their token in."  +
                   "Play continues until there is either a win, lose, or tie.");
                 break;
        case 3:  System.exit(0);
                 break;
        default: System.out.println("");
                 System.out.println("Please try again.");
                 break;
      }
    }
    System.out.println("");
    return menuPlayer;
  }
}
