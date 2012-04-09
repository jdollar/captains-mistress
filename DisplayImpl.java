public class  DisplayImpl implements Display{
  public void ReDrawGameBoard(int[] log, int[][] gameboard){
  }
  public void DrawMenu(){
  	System.out.println("");
  	System.out.println("Main Menu");
  	System.out.println("");
  	System.out.println("1)Play");
  	System.out.println("2)Instructions");
  	System.out.println("3)Quit Game");
  }
  public static void main(String[] args){
  	DisplayImpl link = new DisplayImpl();
  	link.DrawMenu();
  }
}

interface Display{
  public void ReDrawGameBoard(int[] log, int[][] gameboard);
  public void DrawMenu();
}
