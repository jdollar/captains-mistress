
public class AI {
  public int GetInput(int[][] GameBoard){
	  DumbAI dummy = new DumbAI();
	  return dummy.ColumnFill(GameBoard);
  }
}
