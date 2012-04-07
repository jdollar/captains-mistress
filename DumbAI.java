
public class DumbAI extends AI {
	DumbAI(int[][] GameBoardPass){
		super(GameBoardPass);
	}
  public int ColumnFill(int[][] GameBoard){
	  //searches 2D array from bottom left moving upwards and then next column
	  //to the right for a empty spot on the board then selects that column
	  //as next move
	  for(int x = GameBoard[0].length; x > 0; x--){
		  for(int y =0; y < GameBoard.length; y++){
			  if(GameBoard[y][x] != 1 || GameBoard[y][x] != 2){
				  return x;
			  }
		  }
	  }
	  //returns a 0 if board is full
	  return -1;
  }
}
