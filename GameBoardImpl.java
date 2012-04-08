public class  GameBoardImpl implements GameBoard{
  private int[][] gameboard = new int[6][7];

  public int[][] GetGameBoard(){
    return gameboard;
  }
  void ChangeValue(){
  }
}

interface GameBoard{
  public int[][] GetGameBoard();
  void ChangeValue();
}
