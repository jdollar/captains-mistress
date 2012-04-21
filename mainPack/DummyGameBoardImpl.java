package mainPack;

public class DummyGameBoardImpl extends GameBoardImpl implements DummyGameBoard{
	public DummyGameBoardImpl(DummyGameBoardImpl state){
		super(state);
	}
	
	public DummyGameBoardImpl(){
		super();
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
		//try catch for out of bounds
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
		
		return -1;
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

	public void nColumnFilledGameBoard(int columnsToFill) {
		//fills up n columns based off parameters of alternative values
		int count = 0;
		
		for(int x = 0; x < columnsToFill && x < 6; x++){
			count = x;
			for(int y = 0; y < ROW; y++){
				if((count % 2) != 0){
					gameBoard[y][x] = 1;
				}
				else{
					gameBoard[y][x] = 2;
				}
			}
		}
	}

	public void fullGameBoardAlternating() {
		//fills board up with alternating values of 1 and 2
		int count = 0;
		
		for(int x = 0; x < COL; x++){
			count = x;
			for(int y = 0; y < ROW; y++){
				if((count % 2) != 0){
					gameBoard[y][x] = 1;
				}
				else{
					gameBoard[y][x] = 2;
				}
			}
		}
	}

	public void firstColumnHalfGameBoard() {
		//fills half the first column of the gameboard with alternating values
		int count = 0;
		
		for(int x = 0; x < 3; x++){
			if((count % 2) != 0){
				gameBoard[x][0] = 1;
			}
			else{
				gameBoard[x][0] = 2;
			}
		}
	}

	public void fullGameBoardToken(int token) {
		//fills the whole gameboard with ones 
		for(int x = 0; x < COL; x++){
			for(int y = 0; y < ROW; y++){
				gameBoard[y][x] = token;
			}
		}
	}
	
	public void columnNTokens(int place, int token, int column){
		for(int y = 0; y < place; y++){
			this.setValue(getLowestGridValue(column), column, token);
		}
	}
}