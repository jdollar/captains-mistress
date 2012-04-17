package James;

public class Test{
  public static void main(String[] args) {
    int ROW = 6;
    int COL = 7;
    int[][] gameboard = new int[ROW][COL];
    int players;

    //creates an empty game board and sends it back
    for(int x = 0; x < ROW; x++){
      for(int y = 0; y < COL; y++){
        gameboard[x][y] = 0;
      }
    }

    DisplayImpl display = new DisplayImpl();

    players = display.DrawMenu();
    System.out.println(players);
    //display.ReDrawGameBoard(gameboard);
  }
}