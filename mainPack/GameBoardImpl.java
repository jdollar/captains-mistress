package mainPack;
public class  GameBoardImpl implements GameBoard{
        private int[][] gameboard;
	private static int ROW = 6;
	private static int COL = 7;

	public void GameBoardImpl(GameBoardImpl state){
		gameboard = state.getGameBoard();
	}

	public void GameBoardImpl(){
		gameboard = new int[ROW][COL];
		emptyGameBoard();
	}
	
	public int[][] getGameBoard(){
		return gameboard;
	}
	
	public int getNumRows(){
		return ROW;
	}
	
	public int getNumColumns(){
		return COL;
	}
	
	public void setValue(int row, int column, int player){
		//System.out.print(row);
		gameboard[row][column] = player;
	}
	
	public boolean checkValid(int columnNumber){
		if(getLowestGridValue(columnNumber) == -1){
			return false;
		}
		else
			return true;
	}
	
	public int getValue(int row, int column){
		return gameboard[row][column];
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
				System.out.print(gameboard[x][y]);
			}
			System.out.print("\n");
		}
	}
	
	public void emptyGameBoard() {
		//creates an empty game board and sends it back
		for(int x = 0; x < ROW; x++){
			for(int y = 0; y < COL; y++){
				gameboard[x][y] = 0;
			}
		}
	}

}
