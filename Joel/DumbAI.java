package Joel;
import mainPack.*;

public class DumbAI extends AI {
	public DumbAI(DummyGameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
  public int ColumnFill(DummyGameBoardImpl GameBoard){
	  //searches 2D array from bottom left moving upwards and then next column
	  //to the right for a empty spot on the board then selects that column
	  //as next move
	  int[][] testBoard = GameBoard.getGameBoard();
	  for(int x = 6; x > 0; x--){
		  for(int y =0; y < 7; y++){
			  if(testBoard[x][y] != 1 && testBoard[x][y] != 2){
				  return x;
			  }
		  }
	  }
	  //returns a -1 if board is full
	  return -1;
  }
}
