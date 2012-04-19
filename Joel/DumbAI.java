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
	  for(int count = 0; count < GameBoard.getNumColumns(); count++){
		  if(GameBoard.checkValid(count)){
			  return count;
		  }
	  }
	  //returns a -1 if board is full
	  return -1;
  }
}
