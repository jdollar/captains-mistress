package mainPack;
public class GameBoardImpl implements GameBoard{
    //changed to protected to do tests
	protected int[][] gameBoard;
	protected static int ROW = 6;
	protected static int COL = 7;

	public GameBoardImpl(GameBoardImpl state){
		gameBoard = state.getGameBoard();
	}

	public GameBoardImpl(){
		gameBoard = new int[ROW][COL];
		emptyGameBoard();
	}
	
	public int[][] getGameBoard(){
		return gameBoard;
	}
	
	public int getNumRows(){
		return ROW;
	}
	
	public int getNumColumns(){
		return COL;
	}
	
	public void setValue(int row, int column, int player){
		//System.out.print(row);
		gameBoard[row][column] = player;
	}
	
	public boolean checkValid(int columnNumber){
		if(getLowestGridValue(columnNumber) == -1){
			return false;
		}
		else
			return true;
	}
	
	public int getValue(int row, int column){
		return gameBoard[row][column];
	}
	
	public int getLowestGridValue(int columnNumber){
		for(int x = 1; x <= ROW; x++){
				if(this.getValue(ROW - x, columnNumber) == 0){
					return ROW - x;
				}
				else{
					continue;
				}
			}
		
		return 0;
	}
	
	public void displayBoard(){
		for(int x = 0; x < ROW; x++){
			for(int y = 0; y < COL; y++){
				System.out.print(gameBoard[x][y]);
			}
			System.out.print("\n");
		}
	}
	
	public void emptyGameBoard() {
		//creates an empty game board and sends it back
		for(int x = 0; x < ROW; x++){
			for(int y = 0; y < COL; y++){
				gameBoard[x][y] = 0;
			}
		}
	}

}
