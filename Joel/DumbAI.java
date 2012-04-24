package Joel;
import mainPack.*;

public class DumbAI extends AI {
	public DumbAI(GameBoardImpl GameBoardPass){
		super(GameBoardPass);
	}
	
  public int ColumnFill(){
	  //searches 2D array from bottom left moving upwards and then next column
	  //to the right for a empty spot on the board then selects that column
	  //as next move
	  for(int count = 0; count < gameBoard.getNumColumns(); count++){
		  if(gameBoard.checkValid(count)){
			  return count;
		  }
	  }
	  //returns a -1 if board is full
	  return -1;
  }
}
