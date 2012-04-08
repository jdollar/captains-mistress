public class  GameBoardImpl implements GameBoard{
	private int[][] GameBoard = new int[6][7];
 
	public int[][] GetGameBoard(){
	  return GameBoard;
  }
}

interface GameBoard{
}